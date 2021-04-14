package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	static int N, M;
	static int[][] deltas = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		int[][] tomato = new int[N][M];

		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1)
					queue.add(new int[] { i, j });
			}
		}

		int depth = 0;
		boolean[][] visited = new boolean[N][M];
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int[] now = queue.poll();
				if (visited[now[0]][now[1]])
					continue;
				visited[now[0]][now[1]] = true;
				for (int d = 0; d < 4; d++) {
					int nr = now[0] + deltas[d][0];
					int nc = now[1] + deltas[d][1];
					if (isIn(nr, nc) && !visited[nr][nc] && tomato[nr][nc] == 0) {
						tomato[nr][nc] = 1;
						queue.add(new int[] { nr, nc });
					}
				}
			}
			depth++;
		}
		int countZero = 0;
		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 0) {
					countZero++;
					break outer;
				}
			}
		}
		if (countZero > 0) {
			System.out.println(-1);
		} else {
			System.out.println(depth - 1);
		}
	}

	static boolean isIn(int a, int b) {
		return a >= 0 && a < N && b >= 0 && b < M;
	}
}
