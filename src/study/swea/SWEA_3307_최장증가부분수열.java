package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3307_최장증가부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int t=1;t<=T;t++) {
			int N =Integer.parseInt(br.readLine());
			StringTokenizer st= new StringTokenizer(br.readLine());
			int[] numbers = new int[N];
			for(int i=0;i<N;i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			int[] dp = new int[N];
			for(int i=0;i<N;i++) {
				dp[i] = 1;
				for(int j=i-1;j>=0;j--) {
					if(numbers[j]<numbers[i])
						dp[i]= Integer.max(dp[i], dp[j]+1);
				}
			}
			Arrays.sort(dp);
			sb.append("#").append(t).append(" ").append(dp[N-1]).append("\n");
		}
		System.out.println(sb);
	}
}
