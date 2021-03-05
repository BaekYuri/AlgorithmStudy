package study.boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003_피보나치함수 {
	static int T;
	static int max= -1;
	static int[] input;
	static int[][] pibo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		input = new int[T];
		for(int i=0;i<T;i++) {
			input[i] = Integer.parseInt(br.readLine());
			max = Integer.max(max, input[i]);
		}
		pibo = new int[max+1][2];
		pibo[0][0] = 1;
		pibo[0][1] = 0;
		pibo[1][0] = 0;
		pibo[1][1] = 1;
		
		for(int i=2;i<=max;i++) {
			pibo[i][0] = pibo[i-2][0]+pibo[i-1][0];
			pibo[i][1] = pibo[i-2][1]+pibo[i-1][1];
		}
		StringBuilder sb =new StringBuilder();
		for(int i=0;i<input.length;i++) {
			sb.append(pibo[input[i]][0]).append(" ").append(pibo[input[i]][1]).append("\n");
		}
		System.out.println(sb);
	}
}
