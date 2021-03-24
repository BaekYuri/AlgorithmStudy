package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2636_치즈_DFS {
	static int N, M;
	static int[][] space;
	static int time = 0, cheeseNum = 0, lastCheese;
	static boolean[][] air;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		space = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if (space[i][j] == 1)
					cheeseNum++;
			}
		}
		
		while(cheeseNum>0) {
			melt();
			time++;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(time).append("\n").append(lastCheese);
		System.out.println(sb);
	}
	
	static void findAir(int r, int c) {
		air[r][c] = true;
		for(int d=0;d<4;d++) {
			int nr = r+deltas[d][0];
			int nc = c+deltas[d][1];
			if(isIn(nr,nc) && !air[nr][nc] && space[nr][nc]==0) {
				findAir( nr, nc);
			}
		}
		
	}
	static void melt() {
		air = new boolean[N][M];
		lastCheese = cheeseNum;
		findAir(0,0);
		boolean[][] toDelete = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(space[i][j]==0) continue;
				boolean isAir = false;
				for(int d=0;d<4;d++) {
					
					int nr = i+deltas[d][0];
					int nc = j+deltas[d][1];
					
					if(air[nr][nc]) {
						isAir = true;
						break;
					}
				}
				if(isAir) {
					toDelete[i][j] = true;
				}
				
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(toDelete[i][j]) {
					space[i][j]=0;
					cheeseNum--;
				}
			}
		}
	}
	static boolean isIn(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}
}
