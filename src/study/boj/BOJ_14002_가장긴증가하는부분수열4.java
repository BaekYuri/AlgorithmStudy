package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14002_가장긴증가하는부분수열4 {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr =new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		int[] result = new int[N];

		int size = 1;
		result[0] = arr[0];
		for(int i=0;i<N;i++) {
			dp[i] = 1;
			for(int j=i-1;j>=0;j--) {
				if(arr[j]<arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
					if(size<=dp[i]) {
						size = dp[i];
					}
				}
			}
		}
		
		StringBuilder sb= new StringBuilder();
		sb.append(size).append("\n");
		int last= N-1;
		int num = 987654321;
		for(int t=size;t>=1;t--) {
			int idx = 0;
			for(int j=0;j<=last;j++) {
				if(dp[j]==t && num>arr[j]) {
					idx = j;
					break;
				}
			}
			result[t-1] = arr[idx];
			num = arr[idx];
			last = idx;
		}
		for(int i=0;i<size;i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}
