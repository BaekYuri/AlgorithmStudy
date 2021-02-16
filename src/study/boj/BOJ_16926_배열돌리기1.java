package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1 {
	static int[][] array;
	static int N, M, R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		array = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int r = 0; r < R; r++) {
			turn();
		}

		for (int[] row : array) {
			for (int v : row) {
				sb.append(v).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void turn() {
		int T = Math.min(N, M) / 2;
		for (int t = 0; t < T; t++) {
			int keep = array[t][t];
			for (int c = t + 1; c < M - t; c++) {
				array[t][c - 1] = array[t][c];
			}
			for (int r = t + 1; r < N - t; r++) {
				array[r - 1][M - 1 - t] = array[r][M - 1 - t];
			}
			for (int c = M - 1 - 1 - t; c >= t; c--) {
				array[N - 1 - t][c + 1] = array[N - 1 - t][c];
			}
			for (int r = N - 1 - 1 - t; r >= t + 1; r--) {
				array[r + 1][t] = array[r][t];
			}
			array[t + 1][t] = keep;
		}
	}

}
