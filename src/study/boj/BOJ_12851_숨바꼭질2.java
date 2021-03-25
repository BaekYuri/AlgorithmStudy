package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851_숨바꼭질2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int max = Integer.max(N, K);
		if(N==0 && K ==0) {
			System.out.println("0\n1\n");
			return;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		boolean[] visited= new boolean[2*max];
		int[] minDistance = new int[2*max];
		Arrays.fill(minDistance, 987654321);
		int depth = 0;
		int cnt = 0;
		boolean find = false;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int now = queue.poll();
				if(now == K) {
					find = true;
					cnt++;
				}
				if(minDistance[now]<depth) continue;
				minDistance[now]=depth;
				int nr = now+1;
				if(nr>=0 && nr<visited.length && minDistance[nr]>=depth) {
					queue.add(nr);
				}
				nr = now-1;
				if(nr>=0 && nr<visited.length && minDistance[nr]>=depth) {
					queue.add(nr);
				}
				nr = now*2;
				if(nr>=0 && nr<visited.length && minDistance[nr]>=depth) {
					queue.add(nr);
				}
			}
			if(find) {
				break;
			}
			depth++;
		}
		StringBuilder sb= new StringBuilder();
		sb.append(depth).append("\n").append(cnt).append("\n");
		System.out.println(sb);
	}
}
