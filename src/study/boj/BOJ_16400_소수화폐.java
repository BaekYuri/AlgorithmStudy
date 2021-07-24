package study.boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16400_소수화폐 {
	static int[] primeNum;
	public static void main(String[] args) {
		isPrime();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N/2][N+1];
		dp[0] = Arrays.copyOfRange(primeNum, 0, N+1);
		
  		for(int i=2;i<=N;i++) {
			if(primeNum[i]==0) continue;
			for(int j=i;j<=N;j++) {
				if(primeNum[j]==0) continue;
				if(i+j<=N) {
					dp[0][i+j]++;
				}
			}
		}
	}
	
	static void isPrime() {
		primeNum = new int[40001];
		Arrays.fill(primeNum, 1);
		primeNum[0] = 0;
		primeNum[1] = 0;
		for(int i=2;i<=40000;i++) {
			if(primeNum[i]==0) continue;
			for(int j=2;i*j<=40000;j++) {
				primeNum[i*j] = 0;
			}
		}
	}
}
