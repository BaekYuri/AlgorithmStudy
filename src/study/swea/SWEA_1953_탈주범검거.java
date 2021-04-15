package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {

	// 하 우 상 좌
	static int[][] deltas = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static List<int[]> map[][];
	static int mapArr[][];
	static int N, M, R, C, L;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new ArrayList[N][M];
			mapArr = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					mapArr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				map[i] = new ArrayList[M];
				for (int j = 0; j < M; j++) {
					map[i][j] = new ArrayList<>();
					addDirection(i, j, mapArr[i][j]);
				}
			}

			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] { R, C });
			boolean[][] visited = new boolean[N][M];
			visited[R][C] = true;
			int depth = 1;
			while (!queue.isEmpty()) {
				if(depth >=L) break;
				int size = queue.size();
				while (size-- > 0) {
					int[] now = queue.poll();
					for(int i=0, x=map[now[0]][now[1]].size();i<x;i++) {
						int[] temp = map[now[0]][now[1]].get(i);
						if(!visited[temp[0]][temp[1]]) {
							visited[temp[0]][temp[1]]= true;
							queue.add(new int[] {temp[0],temp[1]});
						}
					}
				}
				depth++;
			}
			int cnt= 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(visited[i][j]) cnt++;
				}
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	// 1: 상하좌우 0 1 2 3
	// 2: 상하 0 2
	// 3: 좌우 1 3
	// 4: 상우 1 2
	// 5: 하우 0 1
	// 6: 하좌 0 3
	// 7: 상좌 2 3

	// 하 우 상 좌
	static void addDirection(int i, int j, int direction) {
		switch (direction) {
		case 1:
			for (int d = 0; d < 4; d++) {
				setDeltas(i, j, d);
			}
			break;
		case 2:
			setDeltas(i, j, 0);
			setDeltas(i, j, 2);
			break;
		case 3:
			setDeltas(i, j, 1);
			setDeltas(i, j, 3);
			break;
		case 4:
			setDeltas(i, j, 1);
			setDeltas(i, j, 2);
			break;
		case 5:
			setDeltas(i, j, 0);
			setDeltas(i, j, 1);
			break;
		case 6:
			setDeltas(i, j, 0);
			setDeltas(i, j, 3);
			break;
		case 7:
			setDeltas(i, j, 2);
			setDeltas(i, j, 3);
			break;
		}
	}

	static void setDeltas(int i, int j, int d) {
		int nr = i + deltas[d][0];
		int nc = j + deltas[d][1];
		if (isIn(nr, nc)) {
			switch (d) {
			case 0:
				if (mapArr[nr][nc] == 2 || mapArr[nr][nc] == 1 || mapArr[nr][nc] == 4 || mapArr[nr][nc] == 7) {
					map[i][j].add(new int[] { nr, nc });
				}
				break;
			case 1:
				if (mapArr[nr][nc] == 1 || mapArr[nr][nc] == 3 || mapArr[nr][nc] == 6 || mapArr[nr][nc] == 7)
					map[i][j].add(new int[] { nr, nc });
				break;
			case 2:
				if (mapArr[nr][nc] == 1 || mapArr[nr][nc] == 2 || mapArr[nr][nc] == 5 || mapArr[nr][nc] == 6)
					map[i][j].add(new int[] { nr, nc });
				break;
			case 3:
				if (mapArr[nr][nc] == 1 || mapArr[nr][nc] == 3 || mapArr[nr][nc] == 4 || mapArr[nr][nc] == 5)
					map[i][j].add(new int[] { nr, nc });
				break;
			}

		}
	}

	static boolean isIn(int a, int b) {
		return a >= 0 && b >= 0 && a < N && b < M;
	}
}
