package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_13913_숨바꼭질4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int max = Integer.max(N, K);
		int[] parents = new int[100001];
		if(N==0 && K ==0) {
			System.out.println("0\n0");
			return;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		boolean[] visited= new boolean[100001];
		int depth = 0;
		visited[N] = true;
		parents[N] = -1;
		outer: while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int now = queue.poll();
				
				if(now == K) break outer;
				
				int nr = now+1;
				if(nr>=0 && nr<visited.length && !visited[nr]) {
					visited[nr] = true;
					queue.add(nr);
					parents[nr] = now;
				}
				nr = now-1;
				if(nr>=0 && nr<visited.length && !visited[nr]) {
					visited[nr] = true;
					queue.add(nr);
					parents[nr] = now;
				}
				nr = now*2;
				if(nr>=0 && nr<visited.length && !visited[nr]) {
					visited[nr] = true;
					queue.add(nr);
					parents[nr] = now;
				}
			}
			depth++;
		}
		Stack<Integer> stack = new Stack<>();
        int idx = K;
        while (idx != -1) {
        	stack.push(idx);
            idx = parents[idx];
        }
        
        
		StringBuilder sb= new StringBuilder();
		sb.append(depth).append("\n");
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb);
	}
}
