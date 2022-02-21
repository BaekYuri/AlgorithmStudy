package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5650_핀볼게임 {
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			int[][][] wormhole = new int[5][2][2];
			boolean[] foundWormhole = new boolean[5];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if(map[i][j]>=6) {
						if(foundWormhole[map[i][j]-6]) {
							wormhole[map[i][j]-6][1][0] = i;
							wormhole[map[i][j]-6][1][1] = j;
						}else {
							foundWormhole[map[i][j]-6] = true;
							wormhole[map[i][j]-6][0][0] = i;
							wormhole[map[i][j]-6][0][1] = j;
						}
					}
				}
			}
			
			int score = getScore(N, map, wormhole);
			sb.append("#").append(t).append(" ").append(score).append("\n");
		}
		System.out.println(sb);
	}

	private static int getScore(int n, int[][] map, int[][][] wormhole) {
		int maxScore = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]!=0) continue;
				for(int k=0;k<4;k++) {
					
					int[] nowState = new int[] {i,j,k};
					int nowScore = 0;
					while(true) {
						int ti = nowState[0]+deltas[nowState[2]][0];
						int tj = nowState[1]+deltas[nowState[2]][1];
						if(!isIn(n,ti,tj)) {
							nowState[0] = ti;
							nowState[1] = tj;
							nowState[2] = (nowState[2]+2)%4;
							nowScore++;
						}else {
							if(map[ti][tj]==-1 || (ti==i && tj==j)) {
								break;
							}
							
							if(map[ti][tj]>=6) {
								if(wormhole[map[ti][tj]-6][0][0]==ti && wormhole[map[ti][tj]-6][0][1]==tj) {
									nowState[0] = wormhole[map[ti][tj]-6][1][0];
									nowState[1] = wormhole[map[ti][tj]-6][1][1];
								}else {
									nowState[0] = wormhole[map[ti][tj]-6][0][0];
									nowState[1] = wormhole[map[ti][tj]-6][0][1];
								}
							}else {
								nowState[0] = ti;
								nowState[1] = tj;
								
								if(map[ti][tj]==0) continue;
								
								nowScore++;
								
								if(map[ti][tj]==1) {
									if(nowState[2]==2 || nowState[2]==3) {
										nowState[2] = nowState[2]==2?1:0;
									}else {
										nowState[2] = (nowState[2]+2)%4;
									}
								}else if(map[ti][tj]==2) {
									if(nowState[2]==0 || nowState[2]==3) {
										nowState[2] = nowState[2]==0?1:2;
									}else {
										nowState[2] = (nowState[2]+2)%4;
									}
								}else if(map[ti][tj]==3) {
									if(nowState[2]==0 || nowState[2]==1) {
										nowState[2] = nowState[2]==0?3:2;
									}else {
										nowState[2] = (nowState[2]+2)%4;
									}
								}else if(map[ti][tj]==4) {
									if(nowState[2]==1 || nowState[2]==2) {
										nowState[2] = nowState[2]==1?0:3;
									}else {
										nowState[2] = (nowState[2]+2)%4;
									}
								}else if(map[ti][tj]==5){
									nowState[2] = (nowState[2]+2)%4;
								}
							}
						}
					}
					
					maxScore = Math.max(maxScore, nowScore);
				}
			}
		}
		
		return maxScore;
	}
	
	static boolean isIn(int n, int i, int j) {
		return i>=0 && j>=0 && i<n && j<n;
	}
}
