package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2228_구간나누기 {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	}
}
