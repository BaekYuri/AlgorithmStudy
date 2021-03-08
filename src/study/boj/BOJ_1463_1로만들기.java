package study.boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1463_1로만들기 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N  = scan.nextInt();
		
		int[] result = new int[N+1];
		Arrays.fill(result, Integer.MAX_VALUE);
		result[1]= 0;
		for(int i=2;i<N+1;i++) {
			if(i%3==0) {
				result[i] = Integer.min(result[i/3]+1, result[i]);
			}
			if(i%2==0) {
				result[i] = Integer.min(result[i/2]+1, result[i]);
			}
			result[i] = Integer.min(result[i-1]+1, result[i]);
		}
		System.out.println(result[N]);
	}
}
