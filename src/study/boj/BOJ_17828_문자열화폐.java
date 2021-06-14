package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17828_문자열화폐 {
	static int N, num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		num = Integer.parseInt(st.nextToken());

		if (num < N || num > N * 26) {
			System.out.println("!");
			return;
		}
		int avg = num / N;
		int remain = num % N;
		
		char[] result = new char[N];
		
		Arrays.fill(result, (char)(avg+'A'-1));
		StringBuilder sb = new StringBuilder();
		
		int start = 0;
		int end = N - 1;
		
		int endAdd = 'Z'-result[N-1];
		while (remain > 0) {
			if (remain < endAdd) {
				result[end] += remain;
				remain-=remain;
			} else {
				result[end] = 'Z';
				end--;
				remain-=endAdd;
			}
		}
		
		while(start<end) {
			endAdd = 'Z'-result[end];
			int startAdd = result[start]-'A';
			if(startAdd==0) {
				start++;
			}else {
				if(endAdd>startAdd) {
					result[end]+=startAdd;
					result[start]='A';
					start++;
				}else {
					result[end]='Z';
					result[start]-=endAdd;
					end--;
				}
			}
		}
		for(int i=0;i<N;i++) {
			sb.append(result[i]);
		}
		System.out.println(sb);
		return;
	}
}
