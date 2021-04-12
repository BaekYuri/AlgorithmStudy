package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1249_보급로 {
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = s.charAt(j)-'0';
				}
			}
			Queue<int[]> queue = new LinkedList<>();
			int[][] visited= new int[N][N];
			for(int i=0;i<N;i++) {
				Arrays.fill(visited[i], 987654321);
			}
			queue.add(new int[] {0,0});
			visited[0][0] = map[0][0];
			while(!queue.isEmpty()) {
				int[] temp = queue.poll();
				for(int d=0;d<4;d++) {
					int nr = temp[0]+deltas[d][0];
					int nc = temp[1]+deltas[d][1];
					if(isIn(nr,nc) && visited[nr][nc]>visited[temp[0]][temp[1]]+map[nr][nc]) {
						visited[nr][nc] = visited[temp[0]][temp[1]]+map[nr][nc];
						queue.add(new int[] {nr,nc});
					}
				}
			}
			sb.append("#").append(t).append(" ").append(visited[N-1][N-1]).append("\n");
			
		}
		System.out.println(sb);
	}
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
