package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2579_계단오르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T= Integer.parseInt(br.readLine());
		int floor[] = new int[T];
		for(int t=0;t<T;t++) {
			floor[t] = Integer.parseInt(br.readLine());
		}
		int dp[][] = new int[T][2];

		if(T==1) {
			System.out.println(floor[0]);
			return;
		}
		dp[0][0] =floor[0];
		dp[0][1] =floor[0];
		dp[1][0] =floor[0]+floor[1];
		dp[1][1] = floor[1];
		for(int i=0;i<T-1;i++) {
			dp[i+1][0] =Math.max(dp[i+1][0], dp[i][1]+floor[i+1]);
			if(i!=T-2) {
				dp[i+2][1] =Math.max(dp[i+2][1], dp[i][0]+floor[i+2]);
				dp[i+2][1] =Math.max(dp[i+2][1], dp[i][1]+floor[i+2]);
			}
		}
		
		Arrays.sort(dp[T-1]);
		System.out.println(dp[T-1][1]);
	}
}
