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

public class BOJ_16234_인구이동 {
	static int N, L, R;
	static int[][] map;
	static int[] parents, rank;
	static int result =0;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		setUnion();
		System.out.println(result);
	}

	static void setUnion() {

		int[][] clone = new int[N][N];
		while (true) {
			clone = new int[N][N];
			for (int i = 0; i < N; i++) {
				clone[i] = Arrays.copyOf(map[i], map.length);
			}
			make();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					for (int d = 0; d < 2; d++) {
						int nr = i + deltas[d][0];
						int nc = j + deltas[d][1];
						if (isIn(nr, nc)) {
							int distance = Math.abs(clone[nr][nc] - clone[i][j]);
							if (distance >= L && distance <= R)
								union(i * N + j, nr * N + nc);
						}
					}

				}
			}
			int[][] sum = new int[2500][2];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int root = find(i * N + j);
					sum[root][0]++;
					sum[root][1] += clone[i][j];
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int root = find(i * N + j);
					clone[i][j] = sum[root][1] / sum[root][0];
				}
			}
			boolean isSame = true;
			outer: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]!=clone[i][j]) {
						isSame = false;
						break outer;
					}
				}
			}
			if(isSame) break;
			map = clone;
			result++;
		}
	}

	static void make() {
		parents = new int[N * N];
		rank = new int[N * N];
		for (int i = 0; i < N * N; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		if (rank[aRoot] > rank[bRoot]) {
			parents[bRoot] = aRoot;
		} else {
			parents[aRoot] = bRoot;
			if (rank[aRoot] == rank[bRoot]) {
				rank[bRoot]++;
			}
		}
		return true;
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
