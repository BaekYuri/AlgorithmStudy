package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	static int N, M;
	static int[][] map;
	static int max = 0;
	static List<int[]> virus = new ArrayList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) virus.add(new int[] {i,j});
			}
		}
		combination(3,new int[3], 0);
		
		System.out.println(max);
	}
	static void combination(int toChoose, int[] choosed, int start) {
		if(toChoose == 0) {
			bfs(choosed);
			return;
		}
		for(int i=start;i<N*M;i++) {
			if(map[i/M][i%M]==0) {
				choosed[choosed.length-toChoose]=i;
				combination(toChoose-1,choosed,i+1);
			}
		}
	}
	static int[][] deltas = {{1,0},{0,1},{-1,0},{0,-1}};
	private static void bfs(int[] choosed) {
		int[][] clone = new int[N][M];
		for(int i=0;i<N;i++) {
			clone[i] = Arrays.copyOf(map[i], map[i].length);
		}
		for(int i=0;i<3;i++) {
			clone[choosed[i]/M][choosed[i]%M] =1;
		}
		Queue<int[]> queue =new LinkedList<int[]>();
		boolean[][] visited= new boolean[N][M];
		queue.addAll(virus);
		visited[virus.get(0)[0]][virus.get(0)[1]] = true;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int d=0;d<4;d++) {
				int nr = now[0]+deltas[d][0];
				int nc = now[1]+deltas[d][1];
				if(isIn(nr,nc) && !visited[nr][nc] && clone[nr][nc]==0) {
					clone[nr][nc] = 2;
					queue.add(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
		}
		max = Math.max(max, countZero(clone));
	}
	static int countZero(int[][] m) {
		int cnt =0;
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				if(m[i][j]==0) cnt++;
			}
		}
		return cnt;
	}
	static boolean isIn(int a, int b) {
		return a>=0 && b>=0 && a<N && b<M;
	}
}
