package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {
	static int horse;
	static int[][] horseDeltas = { { 2, 1 }, { -2, 1 }, { 2, -1 }, { -2, -1 }, { 1, 2 }, { -1, 2 }, { 1, -2 },
			{ -1, -2 } };
	static int[][] monkeyDeltas = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] map;
	static int N, M;
	static int result=Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		horse = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
	}

	static void bfs() {
		
		Queue<Info> queue = new LinkedList<>();
		queue.add(new Info(0,0,0,horse)); //r,c,depth,horseNum
		boolean[][][] visited= new boolean[N][M][horse+1];
		visited[0][0][0] = true;
		while(!queue.isEmpty()) {
			Info temp = queue.poll();

			
//			if(visited[temp.r][temp.c][horse-temp.horseNum]) continue;
//			visited[temp.r][temp.c][horse-temp.horseNum] = true;
			if(temp.r==N-1 && temp.c == M-1) {
				result = Integer.min(result, temp.depth);
				break;
			}
			
			for(int d=0;d<4;d++) {
				int nr = temp.r+  monkeyDeltas[d][0];
				int nc = temp.c+ monkeyDeltas[d][1];
				if(isIn(nr,nc) && !visited[nr][nc][horse-temp.horseNum]&& map[nr][nc]==0) {
					queue.add(new Info(nr,nc,temp.depth+1,temp.horseNum));
					visited[nr][nc][horse-temp.horseNum] = true;
				}
			}
			if(temp.horseNum>0) {
				for(int d=0;d<8;d++) {
					int nr = temp.r+ horseDeltas[d][0];
					int nc = temp.c+ horseDeltas[d][1];
					if(isIn(nr,nc) && !visited[nr][nc][horse-temp.horseNum+1] && map[nr][nc]==0) {
						queue.add(new Info(nr,nc,temp.depth+1,temp.horseNum-1));
						visited[nr][nc][horse-temp.horseNum+1] = true;
					}
				}
			}
		}
		
		
	}
	static class Info{
		int r, c, depth, horseNum;
		public Info(int r, int c, int depth, int horseNum) {
			super();
			this.r = r;
			this.c = c;
			this.depth = depth;
			this.horseNum = horseNum;
		}
		
	}
	static boolean isIn(int n, int m) {
		return n >= 0 && m >= 0 && n < N && m < M;
	}
}
