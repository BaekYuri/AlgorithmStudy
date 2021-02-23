package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001_파리퇴치 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s," ");
			int N = Integer.parseInt(st.nextToken());//영역 크기
			int M = Integer.parseInt(st.nextToken());//파리채 크기
			
			int[][] field = new int[N][N];
			int[][] max = new int[N-M+1][N-M+1];
			for(int i=0;i<N;i++) {
				s= br.readLine();
				st = new StringTokenizer(s," ");
				for(int j=0;j<N;j++) {
					field[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int maxValue = Integer.MIN_VALUE;
			
			for(int i=0;i<max.length;i++) {
				for(int j=0;j<max.length;j++) {
					
					for(int a=i;a<i+M;a++) {
						for(int b=j;b<j+M;b++) {
							max[i][j]+=field[a][b];
						}
					}
					maxValue = Integer.max(maxValue, max[i][j]);
					
				}
			}
			
			sb.append("#").append(t).append(" ").append(maxValue).append("\n");

		}
		System.out.println(sb);
	}
}
