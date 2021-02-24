package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974_스도쿠검증 {
	static int[][] sdoku;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			int result = 0;
			sdoku = new int[9][9];
			for(int i=0;i<9;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<9;j++) {
					sdoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(row() && col() && square()) {
				result = 1;
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean row() {
		
		for(int i=0;i<9;i++) {
			boolean[] visited = new boolean[10];
			for(int j=0;j<9;j++) {
				if(visited[sdoku[i][j]]) return false;
				visited[sdoku[i][j]] = true;
			}
		}
		return true;
	}
	static boolean col() {
		for(int j=0;j<9;j++) {
			boolean[] visited = new boolean[10];
			for(int i=0;i<9;i++) {
				if(visited[sdoku[i][j]]) return false;
				visited[sdoku[i][j]] = true;
			}
		}
		return true;
	}
	
	static boolean square() {
		for(int i=0;i<=6;i=i+3) {
			for(int j=0;j<=6;j=j+3) {
				boolean[] visited = new boolean[10];
				for(int k=i;k<i+3;k++) {
					for(int l=j; l<j+3;l++) {
						if(visited[sdoku[k][l]]) return false;
						visited[sdoku[k][l]] = true;
					}
				}
			}
		}
		return true;
	}
}
