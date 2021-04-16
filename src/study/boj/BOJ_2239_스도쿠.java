package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2239_스도쿠 {
	static int[][] sdoku;
	static boolean[][] alreadyNum;
	static boolean[][][] canWrite;
	static boolean found = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sdoku = new int[9][9];
		for(int i=0;i<9;i++) {
			String s = br.readLine();	
			for(int j=0;j<9;j++) {
				sdoku[i][j] = s.charAt(j)-'0';
			}
		}
		//(a,b)
		canWrite = new boolean[10][10][3];
		alreadyNum = new boolean[9][9];
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(sdoku[i][j]==0) continue;
				alreadyNum[i][j] = true;
				//숫자, 
				canWrite[sdoku[i][j]][i]			[0] = true; //가로방향
				canWrite[sdoku[i][j]][j]			[1] = true; //세로방향
				canWrite[sdoku[i][j]][(i/3)*3+j/3]	[2] = true; //네모방향
			}
		}
		permutation(canWrite, 0);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				sb.append(sdoku[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void permutation(boolean[][][] now, int idx) {
		if(found) return;
		if(idx == 81) {
			found = true;
			return;
		}
		if(alreadyNum[idx/9][idx%9]) {
			permutation(now, idx+1);
		}else {
			for(int i=1;i<=9;i++) {
				int row = idx/9;
				int col = idx%9;
				int square = ((idx/9)/3)*3+(idx%9)/3; //0~8
				if(!now[i][row][0] && !now[i][col][1] && !now[i][square][2]) {
					now[i][row][0] = true;
					now[i][col][1] = true;
					now[i][square][2] = true;
					sdoku[idx/9][idx%9] = i;
					permutation(now, idx+1);
					if(found) return;
					now[i][row][0] = false;
					now[i][col][1] = false;
					now[i][square][2] = false;
				}
			}
		}
	}
}
