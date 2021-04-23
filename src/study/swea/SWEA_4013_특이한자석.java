package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4013_특이한자석 {
	static int[][] magnet;
	static int K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			K = Integer.parseInt(br.readLine());
			
			magnet = new int[4][8];
			for(int i=0;i<4;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<8;j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<K;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				dfs(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()),-1, 0, new boolean[4]);
			}
			int result = 0;
			for(int i=0, x=1;i<4;i++, x*=2) {
				result+= magnet[i][0]*x;
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int start, int direction, int NorS, int find, boolean[] visited) {
		visited[start] = true;
		boolean turn = false;
		if(NorS == -1 || (magnet[start][find]!=NorS)) {
			turn = true;
		}
		
		if(turn) {
			//반시계
			if(direction == -1) {
				int temp = magnet[start][0];
				for(int i=0;i<7;i++) {
					magnet[start][i] = magnet[start][i+1];
				}
				magnet[start][7] = temp;
			}else {
				int temp = magnet[start][7];
				for(int i=7;i>=1;i--) {
					magnet[start][i] = magnet[start][i-1];
				}
				magnet[start][0] = temp;
			}
			
			if(start<3 && !visited[start+1]) {
				dfs(start+1, direction*(-1),direction==1?magnet[start][3]:magnet[start][1], 6, visited);
			}
			if(start>0 && !visited[start-1]) {
				dfs(start-1, direction*(-1),direction==1?magnet[start][7]:magnet[start][5], 2, visited);
			}
		}
		
	}
}
