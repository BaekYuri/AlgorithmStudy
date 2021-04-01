package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293_동전1 {
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[N];
		for(int i=0;i<N;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		int[][] dp = new int[N][K+1];
		for(int i=1;i<=K;i++) {
			if(i%coin[0]==0) {
				dp[0][i] = 1;
			}
		}
		for(int i=1;i<N;i++) {
			for(int j=0;j<coin[i];j++) {
				dp[i][j] = dp[i-1][j];
			}
			for(int j=coin[i];j<=K;j++) {
				
				int tmp = dp[i][j-coin[i]]==0?1:dp[i][j-coin[i]];
				dp[i][j] = dp[i-1][j]+tmp;
				
			}
		}
		
		System.out.println(dp[N-1][K]);
	}
}
