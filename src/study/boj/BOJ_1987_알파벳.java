package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static int R, C;
	static char[][] board;
	
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	static int[] horse = {0,0};
	static List<Character> alpabet = new ArrayList<Character>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		for(int i=0;i<R;i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		
		alpabet.add(board[0][0]);
		
		
	}
	
	static boolean dfs(int r, int c, int count) {
		
		for(int i=0;i<4;i++) {
			int nr = r+deltas[i][0];
			int nc = c+deltas[i][1];
			if(!isIn(nr,nc) || alpabet.contains(board[nr][nc])) continue;
			alpabet.add(board[nr][nc]);
			if(dfs(nr,nc,count+1)) {
				
			}
		}
		
		return false;
	}
	static boolean isIn(int a, int b) {
		return a>=0 && a<R && b>=0 && b<C;
	}
}
