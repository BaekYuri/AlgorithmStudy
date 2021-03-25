package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17087_숨바꼭질6 {
	static int N, S;
	static int[] A;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
			A[i] = Math.abs(S-A[i]);
		}
		Arrays.sort(A);
		int result = A[0];
		for(int i=A.length-1 ; i>=1 ; i--) {
			result = gcb(A[i],result);
		}
		System.out.println(result);
	}
	public static int gcb(int a, int b) {
		int result =1;
		while(true) {
			result = a%b;
			a = b;
			b = result;
			if(b==0) break;
		}
		return a;
	}
}
