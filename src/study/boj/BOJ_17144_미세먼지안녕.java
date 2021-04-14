package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
	static int[][] deltas = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int N, M, T;
	static int[][] map;
	static int[] airFresh;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		airFresh = new int[2];
		for (int i = 0, t = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			if (map[i][0] == -1) {
				airFresh[t++] = i;
			}
		}
		for (int t = 0; t < T; t++) {
			int[][] tempMap = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] < 5) {
						tempMap[i][j] += map[i][j];
						continue;
					}
					int cnt = 0;
					int add = map[i][j] / 5;
					for (int d = 0; d < 4; d++) {
						int nr = i + deltas[d][0];
						int nc = j + deltas[d][1];
						if (isIn(nr, nc) && map[nr][nc] != -1) {
							cnt++;
							tempMap[nr][nc] += add;
						}
					}
					tempMap[i][j] += map[i][j] - (add * cnt);

				}
			}
			flowAir(tempMap);
			map = tempMap;
		}
		int cnt= 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==-1) continue;
				cnt+=map[i][j];
			}
		}
		
		System.out.println(cnt);
	}

	static void flowAir(int[][] m) {
		int[] temp = m[0].clone();
		for (int i = 0; i < airFresh[0]; i++) {
			m[i][M - 1] = m[i + 1][M - 1];
		}
		for (int j = M - 1; j >= 1; j--) {
			m[airFresh[0]][j] = m[airFresh[0]][j - 1];
		}
		for (int i = airFresh[0]; i > 0; i--) {
			m[i][0] = m[i - 1][0];
		}
		for (int j = 0; j < M - 1; j++) {
			m[0][j] = temp[j + 1];
		}
		m[airFresh[0]][0] = -1;
		m[airFresh[0]][1] = 0;

		temp = m[airFresh[1]].clone();

		for (int i = airFresh[1]; i < N - 1; i++) {
			m[i][0] = m[i + 1][0];
		}
		for (int j = 0; j < M - 1; j++) {
			m[N - 1][j] = m[N - 1][j + 1];
		}
		for (int i = N - 1; i > airFresh[1]; i--) {
			m[i][M - 1] = m[i - 1][M - 1];
		}
		for (int j = 1; j < M; j++) {
			m[airFresh[1]][j] = temp[j - 1];
		}
		m[airFresh[1]][0] = -1;
		m[airFresh[1]][1] = 0;

	}

	static boolean isIn(int a, int b) {
		return a >= 0 && b >= 0 && a < N && b < M;
	}
}
