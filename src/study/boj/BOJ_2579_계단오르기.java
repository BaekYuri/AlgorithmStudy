package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579_계단오르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T= Integer.parseInt(br.readLine());
		int floor[] = new int[T];
		for(int t=0;t<T;t++) {
			floor[t] = Integer.parseInt(br.readLine());
		}
		int dp[][] = new int[T+1][2];
		
		dp[0][0] = floor[0];
		dp[0][1] = floor[1];
		
		for(int t=1;t<=T;t++) {
			
		}
	}
}
