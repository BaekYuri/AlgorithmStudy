package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {
	static int N;
	static int[] person;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		person = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}

		
		Arrays.sort(person);
		int result = person[0];
		int sum = person[0];
		for(int i=1;i<N;i++) {
			sum = sum+person[i];
			result +=sum;
		}

		System.out.println(result);
	}


}
