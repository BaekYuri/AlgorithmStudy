package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_N과M1_220105 {
	static int N, M;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sb=  new StringBuilder();
		
		permutation(new boolean[N],0, new int[M]);
		
		System.out.println(sb);
	}
	
	static void permutation(boolean[] visited, int idx, int[] choosed) {
		if(idx == M) {
			for(int i=0;i<M;i++) {
				sb.append(choosed[i]+1).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			choosed[idx] = i;
			visited[i] = true;
			permutation(visited, idx+1, choosed);
			visited[i] = false;
		}
	}
}
