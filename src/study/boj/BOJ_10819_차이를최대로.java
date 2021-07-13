package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819_차이를최대로 {
	static int N;
	static int[] arr;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		
		permutation(new boolean[N], 0, new int[N]);
		
		System.out.println(result);
	}

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void permutation(boolean[] visited, int idx, int[] choosed) {
		if(idx==N) {
			int sum =0;
			for(int i=0;i<N-1;i++) {
				sum += Math.abs(choosed[i]-choosed[i+1]);
			}
			result = Math.max(result, sum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			choosed[idx] = arr[i];
			permutation(visited,idx+1,choosed);
			visited[i] = false;
		}
	}
}
