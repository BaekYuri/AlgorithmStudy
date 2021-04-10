package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2225_합분해 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[][] dp = new long[K+1][N+1];
		
		dp[0][0] = 1;
		for(int i=1;i<=K;i++) {
			
			for(int j=0;j<=N;j++) {
				
				for(int k=0;k<=N;k++) {
					
					if(k+j<=N) {
						dp[i][k+j] += dp[i-1][k];
						dp[i][k+j] %=1000000000;
					}
				}
				
			}
		}
		System.out.println(dp[K][N]%1000000000);
	}
}
