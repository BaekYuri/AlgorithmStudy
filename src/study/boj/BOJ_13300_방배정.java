package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300_방배정 {
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[][] room = new int[2][7];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			room[S][grade]++;
		}
		int result = 0;
		for(int i=0;i<2;i++) {
			for(int j=1;j<=6;j++) {
				int temp = room[i][j]/K;
				if(room[i][j]%K !=0) {
					temp++;
				}
				result += temp;
			}
		}
		System.out.println(result);
	}
}
