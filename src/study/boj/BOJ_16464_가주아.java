package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_16464_가주아 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int t=0;t<N;t++) {
			int K = Integer.parseInt(br.readLine());
			
			while(K!=1) {
				if(K%2==1) {
					System.out.println("Gazua");
					break;
				}
				K/=2;
			}
			
			if(K==1) {
				System.out.println("GoHanGang");
			}
		}
		
	}
}
