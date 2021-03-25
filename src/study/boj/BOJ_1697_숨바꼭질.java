package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int max = Integer.max(N, K);
		if(N==0 && K ==0) {
			System.out.println(0);
			return;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		boolean[] visited= new boolean[2*max];
		int depth = 0;
		outer: while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int now = queue.poll();
				if(visited[now]) continue;
				if(now == K) break outer;
				visited[now]= true;
				int nr = now+1;
				if(nr>=0 && nr<visited.length && !visited[nr]) {
					queue.add(nr);
				}
				nr = now-1;
				if(nr>=0 && nr<visited.length && !visited[nr]) {
					queue.add(nr);
				}
				nr = now*2;
				if(nr>=0 && nr<visited.length && !visited[nr]) {
					queue.add(nr);
				}
			}
			depth++;
		}
		System.out.println(depth);
	}
}
