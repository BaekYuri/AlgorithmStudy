package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1904_01타일 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] result = new long[N+1];
		if(N ==1) {
			System.out.println(1);
			return;
		}
		
		result[1] = 1;
		result[2] = 2;
		for(int i=3;i<result.length;i++) {
			result[i] = result[i-2] + result[i-1];
			result[i] %=15746;
		}
		System.out.println(result[N]);
	}
}
