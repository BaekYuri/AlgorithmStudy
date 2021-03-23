package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int input[][] = new int[N+1][3];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int dp[][]= new int[N+1][3];
		for(int i=1;i<=N;i++) {
			dp[i][0] = Integer.min(dp[i-1][1]+input[i][0],dp[i-1][2]+input[i][0]);
			dp[i][1] = Integer.min(dp[i-1][0]+input[i][1],dp[i-1][2]+input[i][1]);
			dp[i][2] = Integer.min(dp[i-1][1]+input[i][2],dp[i-1][0]+input[i][2]);
		}
		
		
		Arrays.sort(dp[N]);
		System.out.println(dp[N][0]);
		return;
	}
}
