package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559_수열 {
	static int N, K;
	static int[] temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		temp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		int result = Integer.MIN_VALUE;
		for(int i=0;i<N-K+1;i++) {
			int t= 0;
			for(int j=i;j<i+K;j++) {
				t += temp[j];
			}
			result = Integer.max(t, result);
		}
		
		System.out.println(result);
	}
}
