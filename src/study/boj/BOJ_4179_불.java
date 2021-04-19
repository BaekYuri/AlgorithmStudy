package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179_불 {
	static int N, M;
	static char[][] map;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		Queue<int[]> fireQueue = new LinkedList<>();
		Queue<int[]> userQueue = new LinkedList<>();
		boolean[][] userVisited = new boolean[N][M];
		boolean[][] fireVisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'J') {
					userQueue.add(new int[] { i, j });
					map[i][j] = '.';
					userVisited[i][j] = true;
				} else if (map[i][j] == 'F') {
					fireQueue.add(new int[] { i, j });
					fireVisited[i][j] = true;
				}
			}
		}
		boolean found = false;
		int sec = 1;
		outer: while (!userQueue.isEmpty()) {
			int size = fireQueue.size();
			while (size-- > 0) {
				int[] now = fireQueue.poll();
				for (int d = 0; d < 4; d++) {
					int nr = now[0] + deltas[d][0];
					int nc = now[1] + deltas[d][1];
					if (isIn(nr, nc) && map[nr][nc] == '.' && !fireVisited[nr][nc]) {
						fireVisited[nr][nc] = true;
						map[nr][nc] = '*';
						fireQueue.add(new int[] { nr, nc });
					}
				}
			}
			size = userQueue.size();
			while (size-- > 0) {
				int[] now = userQueue.poll();
				for (int d = 0; d < 4; d++) {
					int nr = now[0] + deltas[d][0];
					int nc = now[1] + deltas[d][1];
					if (isIn(nr, nc) && map[nr][nc] == '.' && !userVisited[nr][nc]) {
						userVisited[nr][nc] = true;
						userQueue.add(new int[] { nr, nc });
					}
					if (!isIn(nr, nc)) {
						found = true;
						break outer;
					}
				}
			}
			sec++;
		}
		if (found) {
			sb.append(sec).append("\n");
		} else {
			sb.append("IMPOSSIBLE").append("\n");
		}

		System.out.println(sb);
	}

	static boolean isIn(int a, int b) {
		return a >= 0 && b >= 0 && a < N && b < M;
	}
}
