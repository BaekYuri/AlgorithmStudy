package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
	static int N, M, H;
	static int[][] deltas = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 }, { -1, 0, 0 }, { 0, -1, 0 }, { 0, 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int[][][] tomato = new int[H][N][M];

		Queue<int[]> queue = new LinkedList<>();
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					tomato[h][i][j] = Integer.parseInt(st.nextToken());
					if (tomato[h][i][j] == 1)
						queue.add(new int[] { h, i, j });
				}
			}
		}

		int depth = 0;
		boolean[][][] visited = new boolean[H][N][M];
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int[] now = queue.poll();
				if (visited[now[0]][now[1]][now[2]])
					continue;
				visited[now[0]][now[1]][now[2]] = true;
				for (int d = 0; d < 6; d++) {
					int nh = now[0] + deltas[d][0];
					int nr = now[1] + deltas[d][1];
					int nc = now[2] + deltas[d][2];
					if (isIn(nh, nr, nc) && !visited[nh][nr][nc] && tomato[nh][nr][nc] == 0) {
						tomato[nh][nr][nc] = 1;
						queue.add(new int[] { nh, nr, nc });
					}
				}
			}
			depth++;
		}
		int countZero = 0;
		outer: for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tomato[h][i][j] == 0) {
						countZero++;
						break outer;
					}
				}
			}
		}
		if (countZero > 0) {
			System.out.println(-1);
		} else {
			System.out.println(depth - 1);
		}
	}

	static boolean isIn(int h, int a, int b) {
		return h >= 0 && h < H && a >= 0 && a < N && b >= 0 && b < M;
	}
}
