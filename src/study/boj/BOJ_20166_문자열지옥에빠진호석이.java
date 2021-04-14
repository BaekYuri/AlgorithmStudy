package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20166_문자열지옥에빠진호석이 {
	static int N, M, K, maxLength;
	static char[][] map;
	static int[][] deltas = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
	static HashMap<String, Integer> output = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		String[] godStr = new String[K];
		for(int k=0;k<K;k++) {
			godStr[k]= br.readLine();
			maxLength = Math.max(maxLength, godStr[k].length());
			output.put(godStr[k], 0);
		}
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				dfs(i,j,0,Character.toString(map[i][j]));
			}
		}
		for(int k=0;k<K;k++) {
			sb.append(output.get(godStr[k])).append("\n");
		}
		System.out.println(sb);
	}
	static void dfs(int r, int c, int depth, String result) {
		if(output.containsKey(result)) {
			output.put(result, output.get(result)+1);
		}
		if(depth ==maxLength-1) {
			return;
		}
		
		for(int d=0;d<8;d++) {
			int nr= (r+deltas[d][0])%N;
			int nc= (c+deltas[d][1])%M;
			nr = nr==-1?N-1:nr;
			nc = nc==-1?M-1:nc;
			
			dfs(nr,nc,depth+1,result+map[nr][nc]);
		}
	}
}
