package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {
	static int N, W, H;
	static int[][] blockMap;
	static int result;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {

			result = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			blockMap = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					blockMap[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			permutation(N, blockMap);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	static void permutation(int toChoose, int[][] map) {
		if (toChoose == 0) {
			int cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] > 0)
						cnt++;
				}
			}
			result = Math.min(result, cnt);
			return;
		}
		for (int i = 0; i < W; i++) {
			int[][] tempMap = doBreak(i,map);
			permutation(toChoose - 1, tempMap);
			tempMap = map;
		}

	}

	static int[][] doBreak(int choosed, int[][] map) {
		int[][] mapClone = new int[H][W];
		for (int i = 0; i < H; i++) {
			mapClone[i] = map[i].clone();
		}

		int temp = 0;
		boolean found = false;
		while (temp < H) {
			if (mapClone[temp][choosed] != 0) {
				found = true;
				break;
			}
			temp++;
		}
		if (found) {
			int num = mapClone[temp][choosed];
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] { temp, choosed, num });
			boolean[][] visited = new boolean[H][W];

			while (!queue.isEmpty()) {
				int[] now = queue.poll();
				if (visited[now[0]][now[1]])
					continue;
				visited[now[0]][now[1]] = true;
				mapClone[now[0]][now[1]] = 0;
				for (int a = 1; a < now[2]; a++) {
					for (int d = 0; d < 4; d++) {

						int nr = now[0] + deltas[d][0] * a;
						int nc = now[1] + deltas[d][1] * a;
						if (isIn(nr, nc)) {
							queue.add(new int[] { nr, nc, mapClone[nr][nc] });
						}
					}

				}
			}
			
			setBlock(mapClone);
		}


		return mapClone;
	}

	static void setBlock(int[][] m) {
		for (int i = 0; i < W; i++) {
			int[] temp = new int[H];
			for (int j = H - 1, t = H - 1; j >= 0; j--) {
				if (m[j][i] != 0) {
					temp[t--] = m[j][i];
				}
			}

			for (int j = 0; j < H; j++) {
				m[j][i] = temp[j];
			}
		}
	}

	static boolean isIn(int a, int b) {
		return a >= 0 && b >= 0 && a < H && b < W;
	}
}
