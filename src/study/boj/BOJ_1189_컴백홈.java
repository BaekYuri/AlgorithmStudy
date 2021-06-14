package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1189_컴백홈 {
	static int R, C, K;
	static int result = 0;
	static char[][] map;
	static int[][] deltas= {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		dfs(1, new boolean[R][C], R-1,0);
		System.out.println(result);
		
	}
	static boolean isIn(int a, int b) {
		return a>=0 && b>=0 && a<R && b<C;
	}
	static void dfs(int depth, boolean[][] visited, int x, int y) {
		if(depth>K) return;
		if(x== 0 && y==C-1) {
			if(depth==K) {
				result++;
			}
			return;
		}
		if(visited[x][y]) return ;
		visited[x][y] = true;
		for(int d=0;d<4;d++) {
			int nr = x+deltas[d][0];
			int nc = y+deltas[d][1];
			if(isIn(nr,nc) && map[nr][nc]!='T') {
				dfs(depth+1, visited, nr,nc);
			}
		}
		visited[x][y] = false;
	}
}
