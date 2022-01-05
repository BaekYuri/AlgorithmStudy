package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7568_덩치 {
	static int[][] person;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		person = new int[N][2];
		for(int n=0;n<N;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			person[n][0] = Integer.parseInt(st.nextToken());
			person[n][1] = Integer.parseInt(st.nextToken());
		}
		
		
		int[] result = new int[N];
		for(int n=0;n<N;n++) {
			int[] now = person[n];
			for(int i=0;i<N;i++) {
				if(i==n) continue;
				if(person[i][0]>now[0] &&person[i][1]>now[1]) {
					result[n]++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int n=0;n<N;n++) {
			sb.append(result[n]+1).append(" ");
		}
		System.out.println(sb);
	}
}
