package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭_220318 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] objects = new int[N+1][2];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			
			objects[i][0] = Integer.parseInt(st.nextToken());
			objects[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		int[][] bagsDP = new int[N+1][K+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=K;j++) {
				if(j<objects[i][0]) {
					bagsDP[i][j] = bagsDP[i-1][j];
				}else {
					bagsDP[i][j] = Math.max(bagsDP[i-1][j-objects[i][0]]+objects[i][1], bagsDP[i-1][j]);
				}
			}
		}
		
		System.out.println(bagsDP[N][K]);
		
	}
}
