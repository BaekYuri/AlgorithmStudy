package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {
	static int N, M;
	static int[][] map;
	static int[][] cctv;
	static int cctvCnt;
	static int result = Integer.MAX_VALUE;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cctvCnt = 0;
		map = new int[N][M];
		cctv = new int[8][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6) {
					cctv[cctvCnt++] = new int[] {i,j,map[i][j]};
					map[i][j] = 0;
				}
			}
		}
		permutation(0,new boolean[N][M]);
		
		System.out.println(result);
	}

	static void permutation(int idx, boolean[][] visited) {
		if (idx == cctvCnt) {
			int cnt = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(!visited[i][j] && map[i][j]==0) cnt++;
				}
			}
			result = Math.min(result, cnt);
			return;
		}

		int[] temp = cctv[idx];
		int t = temp[2];
		int d = t == 5 ? 1 : t == 2 ? 2 : 4;
		boolean[][] clone = getClone(visited);
		for (int i = 0; i < d; i++) {
			setVisited(temp, i, clone);
			permutation(idx + 1, clone);
			clone = getClone(visited);
		}
	}

	static void setVisited(int[] now, int d, boolean[][] visited) {
		int depth = 0;
		switch (now[2]) {
		case 2:
			depth = 0;

			while (true) {
				int nr = now[0] + deltas[d + 2][0] * depth;
				int nc = now[1] + deltas[d + 2][1] * depth;
				if (isIn(nr, nc)) {
					visited[nr][nc] = true;
					if (map[nr][nc] == 6)
						break;
				} else {
					break;
				}
				depth++;
			}
		case 1:
			depth = 0;
			while (true) {
				int nr = now[0] + deltas[d][0] * depth;
				int nc = now[1] + deltas[d][1] * depth;
				if (isIn(nr, nc)) {
					visited[nr][nc] = true;
					if (map[nr][nc] == 6)
						break;
				} else {
					break;
				}
				depth++;
			}
			break;
		case 5:
			depth = 0;
			while (true) {
				int nr = now[0] + deltas[(d+3)%4][0] * depth;
				int nc = now[1] + deltas[(d+3)%4][1] * depth;
				if (isIn(nr, nc)) {
					visited[nr][nc] = true;
					if (map[nr][nc] == 6)
						break;
				} else {
					break;
				}
				depth++;
			}
		case 4:
			depth = 0;
			while (true) {
				int nr = now[0] + deltas[(d+2)%4][0] * depth;
				int nc = now[1] + deltas[(d+2)%4][1] * depth;
				if (isIn(nr, nc)) {
					visited[nr][nc] = true;
					if (map[nr][nc] == 6)
						break;
				} else {
					break;
				}
				depth++;
			}
		case 3:
			for(int i=0, x=d; i<2;i++, x++) {
				depth = 0;
				while (true) {
					int nr = now[0] + deltas[x%4][0] * depth;
					int nc = now[1] + deltas[x%4][1] * depth;
					if (isIn(nr, nc)) {
						visited[nr][nc] = true;
						if (map[nr][nc] == 6)
							break;
					} else {
						break;
					}
					depth++;
				}

			}
			break;
		}
	}

	static boolean[][] getClone(boolean[][] arr) {
		boolean[][] clone = new boolean[arr.length][arr[0].length];
		for (int i = 0; i < clone.length; i++) {
			for (int j = 0; j < clone[0].length; j++) {
				clone[i][j] = arr[i][j];
			}
		}
		return clone;
	}

	static boolean isIn(int a, int b) {
		return a >= 0 && b >= 0 && a < N && b < M;
	}
}
