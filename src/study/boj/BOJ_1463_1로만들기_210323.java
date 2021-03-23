package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_1로만들기_210323 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		if(N ==1) {
			System.out.println(0);
			return;
		}
		if(N<=3) {
			System.out.println(1);
			return;
		}
		dp[2] =1;
		dp[3] =1;
		for(int i=4;i<=N;i++) {
			dp[i] = dp[i-1]+1;
			if(i%2==0) {
				dp[i] = Integer.min(dp[i/2]+1, dp[i]);
			}
			if(i%3==0) {
				dp[i] = Integer.min(dp[i/3]+1, dp[i]);
			}
		}
		System.out.println(dp[N]);
	}
}
