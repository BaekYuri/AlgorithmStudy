package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17836_공주님을구해라 {
	static int N, M, T;
	static int[][] map;
	static int[][] deltas = {{0,1},{1,0},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][][] visited= new boolean[N][M][2];
		int sword = map[0][0]==2?1:0;
		visited[0][0][sword] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0,sword});
		int depth = 0;
		boolean found = false;
		outer: while(!queue.isEmpty()) {
			if(depth>T) break;
			int size = queue.size();
			while(size-->0) {
				int[] now = queue.poll();
				if(now[0]==N-1 && now[1]==M-1) {
					found = true;
					break outer;
				}
				for(int d=0;d<4;d++) {
					int nr = now[0]+ deltas[d][0];
					int nc = now[1]+ deltas[d][1];
					if(isIn(nr,nc)) {
						if(map[nr][nc]==0 && !visited[nr][nc][now[2]]) {
							visited[nr][nc][now[2]] = true;
							queue.add(new int[] {nr,nc,now[2]});
						}else if(map[nr][nc]==1 && now[2]==1 && !visited[nr][nc][now[2]]) {
							visited[nr][nc][now[2]] = true;
							queue.add(new int[] {nr,nc,now[2]});
						}else if(map[nr][nc]==2 && !visited[nr][nc][1]) {
							visited[nr][nc][1] = true;
							queue.add(new int[] {nr,nc,1});
						}
					}
					
				}
			}
			depth++;
		}
		
		if(found) {
			System.out.println(depth);
		}else {
			System.out.println("Fail");
		}
	}
	static boolean isIn(int a, int b) {
		return a>=0 && b>=0 && a<N && b<M;
	}
}
