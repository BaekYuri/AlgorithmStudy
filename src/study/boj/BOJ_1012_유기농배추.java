package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	static int T, M, N, K;
	static int[][] baechu;
	static int[][] deltas = {{0,1},{1,0},{-1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			baechu = new int[N][M];
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				baechu[y][x] = 1;
				
				
			}
			
			sb.append(bfs()).append("\n");
			
		}
		System.out.println(sb);
		
	}
	
	public static int bfs() {
		
		int result = 0;
		
		boolean[][] visited = new boolean[N][M];
		
		// M : 가로(열) N : 세로(행)
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				if(visited[i][j] || baechu[i][j]==0) continue;
				result++;
				
				Queue<int[]> queue = new LinkedList<>();
				visited[i][j] = true;
				queue.add(new int[] {i,j});
				
				while(!queue.isEmpty()) {
					
					int[] now = queue.poll();
					
					for(int d=0;d<4;d++) {
						
						int nr = now[0]+deltas[d][0];
						int nc = now[1]+deltas[d][1];
						
						if(nr>=0 && nr<N && nc>=0 && nc<M && baechu[nr][nc]==1 && !visited[nr][nc]) {
							visited[nr][nc] = true;
							queue.add(new int[] {nr,nc});
						}
						
					}
				}
			}
		}
		
		return result;
	}
	
}
