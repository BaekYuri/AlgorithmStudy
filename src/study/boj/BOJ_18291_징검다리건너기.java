package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_18291_징검다리건너기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			 if(N <=2) {
				System.out.println(1);
				continue;
			}
			BigInteger temp = new BigInteger("1");
			BigInteger two = new BigInteger("2");
			BigInteger big = new BigInteger("2");
			N-=2;
			while(N>0) {
				if((N&1)!=1) {
					temp = temp.multiply(big);
	
				}
				N = N/2;
				big = big.pow(2);
			}
			
			big = big.multiply(temp);
			big = big.mod(new BigInteger("1000000007"));
			
			System.out.println(big);
		}
	}
}
