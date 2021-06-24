package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5549_행성탐사 {
	static int N, M,K;
	static char[][] map;
	static int[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		K =Integer.parseInt(br.readLine());
		
		map = new char[N][M];
		dp = new int[N][M][3];
		
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j);
				switch(map[i][j]) {
				case 'J':
					dp[i][j][0]++;
					break;
				case 'O':
					dp[i][j][1]++;
					break;
				case 'I':
					dp[i][j][2]++;
					break;
				}
				if(j<M-1) {
					dp[i][j+1][0]+=dp[i][j][0];
					dp[i][j+1][1]+=dp[i][j][1];
					dp[i][j+1][2]+=dp[i][j][2];
				}
			}
			
			if(i>0) {
				for(int j=0;j<M;j++) {
					dp[i][j][0]+=dp[i-1][j][0];
					dp[i][j][1]+=dp[i-1][j][1];
					dp[i][j][2]+=dp[i-1][j][2];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken())-1;
			int startY = Integer.parseInt(st.nextToken())-1;
			int endX = Integer.parseInt(st.nextToken())-1;
			int endY = Integer.parseInt(st.nextToken())-1;
			if(startX == 0 && startY == 0) {
				
			}
			int resultJ = dp[endX][endY][0];
			int resultO = dp[endX][endY][1];
			int resultI = dp[endX][endY][2];
			
			if(startX == 0 && startY != 0) {
				resultJ -= dp[endX][startY-1][0];
				resultO -= dp[endX][startY-1][1];
				resultI -= dp[endX][startY-1][2];
			}else if(startX!=0 && startY ==0) {
				resultJ -= dp[startX-1][endY][0];
				resultO -= dp[startX-1][endY][1];
				resultI -= dp[startX-1][endY][2];
			}else if(startX!=0 && startY!=0) {
				resultJ = dp[endX][endY][0]-dp[endX][startY-1][0]-dp[startX-1][endY][0]+dp[startX-1][startY-1][0];
				resultO = dp[endX][endY][1]-dp[endX][startY-1][1]-dp[startX-1][endY][1]+dp[startX-1][startY-1][1];
				resultI = dp[endX][endY][2]-dp[endX][startY-1][2]-dp[startX-1][endY][2]+dp[startX-1][startY-1][2];
			}
			sb.append(resultJ).append(" ").append(resultO).append(" ").append(resultI).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
}
