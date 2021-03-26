package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분수열 {
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
		Arrays.fill(dp, 987654321);
		int size = 0;
		for(int i=0;i<N;i++) {
			int tmp = Arrays.binarySearch(dp, 0, size, arr[i]);
			if(tmp>=0) continue;
			tmp = Math.abs(tmp+1);
			dp[tmp] = Math.min(dp[tmp],arr[i]);
			if(tmp==size) size++;
		}
		System.out.println(size);
	}
}
