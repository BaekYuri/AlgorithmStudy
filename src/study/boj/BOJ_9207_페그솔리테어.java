package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9207_페그솔리테어 {
	static int T;
	static int N = 5, M=9;
	static char[][] map;
	static int[][] deltas = {{1,0},{0,1},{-1,0},{0,-1}};
	static int pinCount;
	static int minMove;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T =Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int t=1;t<=T;t++) {
			map = new char[N][M];
			pinCount= 0;
			minMove= 0;
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				for(int j=0;j<M;j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j]=='o') {
						pinCount++;
					}
				}
			}
			if(t!=T) br.readLine();
			
			dfs(map, 0);
			sb.append(pinCount).append(" ").append(minMove).append("\n");
		}
		System.out.print(sb);
	}
	
	static void dfs(char[][] m,int cnt) {
		
		int pin = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(m[i][j]!='o') continue;
				pin++;
				for(int d=0;d<4;d++) {
					int nr1 = i+ deltas[d][0];
					int nc1 = j+ deltas[d][1];
					
					int nr2 = i+ deltas[d][0]*2;
					int nc2 = j+ deltas[d][1]*2;
					
					if(isIn(nr1,nc1) && isIn(nr2,nc2) && m[nr1][nc1]=='o' && m[nr2][nc2]=='.') {
						char[][] clone = getClone(m);
						clone[i][j] = '.';
						clone[nr1][nc1]='.';
						clone[nr2][nc2] = 'o';
						dfs(clone, cnt+1);
					}
				}
			}
		}
		if(pin<pinCount) {
			pinCount = pin;
			minMove = cnt;
		}
		
	}
	
	static char[][] getClone(char[][] m){
		char[][] res = new char[m.length][m[0].length];
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				res[i][j] = m[i][j];
			}
		}
		return res;
	}
	static boolean isIn(int a, int b) {
		return a>=0 && b>=0 && a<N && b<M;
	}
}
