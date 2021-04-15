package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473_세용액 {
	static int N;
	static int[] liquid;
	static long range;
	static int[] choosed;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		liquid = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(liquid);
		StringBuilder result = new StringBuilder();
		range = Long.MAX_VALUE;
		int start = 0;
		int end = N - 1;
		while (start < end - 1) {
			int toGet = -(liquid[start] + liquid[end]);
			int temp = Arrays.binarySearch(liquid, start + 1, end, toGet);
			long x = Long.MAX_VALUE;
			if (liquid[start] >= 0) {
				x = (long) liquid[start] + (long) liquid[start + 1] + (long) liquid[start + 2];

				if (Math.abs(range) > Math.abs(x)) {
					range = x;
					result = new StringBuilder();
					result.append(liquid[start]).append(" ").append(liquid[start + 1]).append(" ")
							.append(liquid[start + 2]);
				}
				
			}
			if (liquid[end] <= 0) {
				x = (long) liquid[end] + (long) liquid[end - 1] + (long) liquid[end - 2];
				if (Math.abs(range) > Math.abs(x)) {
					range = x;
					result = new StringBuilder();
					result.append(liquid[end - 2]).append(" ").append(liquid[end - 1]).append(" ").append(liquid[end]);
				}
			}
			int tempResult = -temp - 1;
			if (temp < 0 && tempResult>start && tempResult<end) {
				

				x = (long) liquid[start] + (long) liquid[tempResult] + (long) liquid[end];
				long y = Long.MAX_VALUE;
				if (tempResult - 1 != start)
					y = (long) liquid[start] + (long) liquid[tempResult - 1] + (long) liquid[end];
				if (Math.abs(range) > Math.abs(x))
					range = x;
				if (Math.abs(range) > Math.abs(y))
					range = y;
				if (range == x) {
					result = new StringBuilder();
					result.append(liquid[start]).append(" ").append(liquid[tempResult]).append(" ").append(liquid[end]);
				} else if (range == y) {
					result = new StringBuilder();
					result.append(liquid[start]).append(" ").append(liquid[tempResult - 1]).append(" ")
							.append(liquid[end]);
					x = y;
				}

			} else if(temp>=0){
				result = new StringBuilder();
				result.append(liquid[start]).append(" ").append(liquid[temp]).append(" ").append(liquid[end]);
				break;
			}
			if (x > 0) {
				end--;
			} else {
				start++;
			}
		}

		System.out.println(result);
	}
}
