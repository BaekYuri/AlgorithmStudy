


import java.util.Scanner;

public class BOJ_15651_N과M3 {
	static int N;
	static int M;
	
	
	static StringBuilder sb = new StringBuilder();
	static int[] count;
	
	static void print(int n, int m) {
		if (n ==m) {
			for(int r : count) {
				sb.append(r).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		
		for (int i = 1; i <= N; i++) {
			
			count[n] = i;
			print(n+1,m);

			
		}
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		 
		count = new int[M];
		print(0, M);
		System.out.println(sb);
		
	}
}
