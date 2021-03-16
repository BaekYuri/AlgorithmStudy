package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2167_타일위의대각선 {
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if(N<M) {
			int temp =N;
			N=M;
			M=temp;
		}
		
		int g = gcd(N,M);
		
		N/=g;
		M/=g;
		
		int result= N+N%M;
		
		if(N%M==0) {
			result= N;
		}else {
			result = N+M-1;
		}
		System.out.println(result*g);
		
	}
	
	static int gcd(int x, int y) {

		int n;
		while(y!=0) {
			n = x%y;
			x = y;
			y = n;
		}
		return x;
	}
}
