package study.boj;

import java.util.Scanner;

public class BOJ_11729_하노이탑이동순서 {
	static StringBuilder sb;
	static int result;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		sb = new StringBuilder();
		result = 0;
		hanoi(N, 1, 3, 2);
		System.out.println(result);
		System.out.println(sb);
	}

	private static void hanoi(int n, int i, int j, int k) {
		if(n==1) {
			sb.append(i).append(" ").append(j).append("\n");
			result++;
			return;
		}
		hanoi(n-1, i, k, j);
		sb.append(i).append(" ").append(j).append("\n");
		result++;
		hanoi(n-1,k, j, i);
		
	}
}
