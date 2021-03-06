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
			if(K ==2) {
				System.out.println("GoHanGang");
				return;
			}
			boolean isTrue = false;
			
			outer : for(int i=2;i<K;i++) {
				BigInteger result = new BigInteger("1");
				result = result.multiply(new BigInteger(Integer.toString(i)));
				result = result.multiply(new BigInteger(Integer.toString(i+1)));
				result = result.divide(new BigInteger("2"));
				
				for(int j=1;j<i;j++) {
					BigInteger value = new BigInteger("1");
					value = value.multiply(new BigInteger(Integer.toString(j)));
					value = value.multiply(new BigInteger(Integer.toString(j+1)));
					value = value.divide(new BigInteger("2"));
					BigInteger sum = result.subtract(value);
					if(sum.equals(new BigInteger(Integer.toString(K)))) {
						isTrue = true;
						break outer;
					}
				}
				
			}
			if(isTrue) {
				System.out.println("Gazua");
			}else {
				System.out.println("GoHanGang");
			}
		}
		
	}
}
