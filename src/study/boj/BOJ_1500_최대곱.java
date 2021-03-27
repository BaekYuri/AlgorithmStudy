package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1500_최대곱 {
	static int S, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] result = new int[K];
		Arrays.fill(result, S/K);
		int remain = S%K;
		if(remain>0) {
			for(int i=0;i<remain;i++) {
				result[i]++;
			}
		}
		long max = 1;
		for(int i=0;i<K;i++) {
			max*=result[i];
		}
		System.out.println(max);
	}

}
