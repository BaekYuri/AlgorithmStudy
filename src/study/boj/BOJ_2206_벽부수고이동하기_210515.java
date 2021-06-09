package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기_210515 {
	static int N, M;
	static int[][] deltas= {{1,0},{0,1},{-1,0},{0,-1}};
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {0,0,0});
		boolean[][][] visited=  new boolean[N][M][2];
		visited[0][0][0]= true;
		int sec = 0;
		boolean found = false;
		outer: while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int[] now = queue.poll();
				if(now[0]==N-1 && now[1]==M-1) {
					found = true;
					break outer;
				}
				for(int d=0;d<4;d++) {
					int nr = now[0]+deltas[d][0];
					int nc = now[1]+deltas[d][1];
					
					if(isIn(nr,nc)) {
						if(map[nr][nc]=='1' && now[2]==0 && !visited[nr][nc][1]) {
							visited[nr][nc][1] = true;
							queue.add(new int[] {nr,nc,1});
						}else if(map[nr][nc]=='0' && !visited[nr][nc][now[2]]) {
							visited[nr][nc][now[2]] = true;
							queue.add(new int[] {nr,nc,now[2]});
						}
					}
				}
			}
			sec++;
		}
		
		if(found) {
			System.out.println(sec+1);
		}else {
			System.out.println(-1);
		}
		
	}
	static boolean isIn(int a, int b) {
		return a>=0 && b>=0 && a<N && b<M;
	}
}
