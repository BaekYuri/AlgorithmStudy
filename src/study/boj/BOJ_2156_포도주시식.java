package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156_포도주시식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T= Integer.parseInt(br.readLine());
		int wine[] = new int[T];
		for(int t=0;t<T;t++) {
			wine[t] = Integer.parseInt(br.readLine());
		}
		int dp[][] = new int[T][2];

		if(T==1) {
			System.out.println(wine[0]);
			return;
		}
		
		dp[0][0] =wine[0]; // 뒤에가 0이면 앞에 와인을 먹은거
		dp[0][1] =wine[0]; // 뒤에가 1이면 앞에 와인을 안먹은거
		dp[1][0] =wine[0]+wine[1];
		dp[1][1] = wine[1];
		int max = dp[1][0];
		for(int i=0;i<T-1;i++) {
			dp[i+1][0] =Math.max(dp[i+1][0], dp[i][1]+wine[i+1]);
			max = Math.max(max, dp[i+1][0]);
			for(int j=i+2;j<T;j++) {
				dp[j][1] =Math.max(dp[j][1], dp[i][0]+wine[j]);
				dp[j][1] =Math.max(dp[j][1], dp[i][1]+wine[j]);
				max = Math.max(max, dp[j][1]);
			}
			
			
		}
		
		System.out.println(max);
	}
}
