package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1327_소트게임 {
	static int N, K;
	static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		num = new int[N];
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	}
	static void permutation(int toChoose, int[] choosed) {
		
	}
	static int[] swap(int[] n) {
		int a= 0;
		int b= n.length-1;
		while(a<b) {
			int temp = n[a];
			n[a] = n[b];
			n[b] = temp;
			a++;
			b--;
		}
		return n;
	}
}
