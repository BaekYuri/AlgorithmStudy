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
	static int max = Integer.MIN_VALUE;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		for(int i=0;i<R;i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		
		dfs(0,0,1,new boolean[26]);
		
		System.out.println(max);
	}
	
	static void dfs(int r, int c, int count,boolean[] visited) {
		if(max ==26) {
			return;
		}
		int idx = board[r][c]-'A';
		visited[idx] = true;
		for(int i=0;i<4;i++) {
			int nr = r+deltas[i][0];
			int nc = c+deltas[i][1];
			if(!isIn(nr,nc) || visited[board[nr][nc]-'A']) continue;
			dfs(nr,nc,count+1,visited);
			
		}
		visited[idx] = false;
		max = Integer.max(max,count);

	}
	static boolean isIn(int a, int b) {
		return a>=0 && a<R && b>=0 && b<C;
	}
}
