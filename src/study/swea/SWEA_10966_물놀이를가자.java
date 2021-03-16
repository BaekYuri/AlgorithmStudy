package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_10966_물놀이를가자 {
	static int N,M;
	static char[][] map;
	static int result;
	static List<int[]> earth;
	static int[] resultArr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			earth = new ArrayList<>();
			for(int i=0;i<N;i++) {
				String s= br.readLine();
				for(int j=0;j<M;j++) {
					map[i][j] = s.charAt(j);
					if(s.charAt(j)=='L') {
						earth.add(new int[] {i,j});
					}
					
				}
			}
			resultArr = new int[earth.size()];
			Arrays.fill(resultArr, Integer.MAX_VALUE);
			result =0;
			for(int i=0;i<earth.size();i++) {
				dfs(earth.get(i)[0],earth.get(i)[1],new boolean[N][M],0,i);
			}
			for(int a: resultArr) {
				result+=a;
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	static void dfs(int pointX, int pointY, boolean[][] visited, int length,int idx) {
		if(length>=resultArr[idx]) {
			return;
		}
		boolean[][] clone = new boolean[N][M];
		for(int i=0;i<N;i++) {
			clone[i] = visited[i].clone();
		}
		clone[pointX][pointY] = true;
		for(int d=0;d<4;d++) {
			int nr = pointX+deltas[d][0];
			int nc = pointY+deltas[d][1];
			if(isIn(nr,nc) && !clone[nr][nc]) {
				
				if(map[nr][nc]=='W') {
					resultArr[idx] = Integer.min(resultArr[idx], length+1);
					return;
				}else {
					dfs(nr,nc,clone,length+1, idx);
				}
			}
		}
	}
	
	static boolean isIn(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}
}
