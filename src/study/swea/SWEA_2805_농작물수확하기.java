package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SWEA_2805_농작물수확하기 {
	static int[][] farm;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			farm = new int[N][N];
			int result = 0;
			for(int i=0;i<N;i++) {
				String s= br.readLine();
				for(int j=0;j<N;j++) {
					farm[i][j]= s.charAt(j)-48;
				}
			}
			int center = N/2;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int ni = Math.abs(i-center);
					int nj = Math.abs(j-center);
					if((ni+nj)<=center){
						result+=farm[i][j];
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
