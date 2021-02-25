package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10703_유성 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] picture = new char[R][C];
		boolean[][] land = new boolean[R][C];
		int count = 0;
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				picture[i][j] = s.charAt(j);
				if (picture[i][j] == '#') {
					land[i][j] = true;
				} else if (picture[i][j] == 'X') {
					count++;
				}
			}
		}

		boolean canGo = true;
		if (count != 0) {

			int length = Integer.MAX_VALUE;
			for (int j = 0; j < C; j++) {
				int under = -1;
				int up = R - 1;
				for (int i = 0; i < R; i++) {
					if (picture[i][j] == '#') {
						under = i;
						break;
					}
					if (picture[i][j] == 'X') {
						up = i;

					}
				}
				if (up == -1) {
					continue;
				}

				length = Integer.min(length, up - under);

			}
			for (int i = R - 1; i >= 0; i--) {
				for (int j = 0; j < C; j++) {
					if (!land[i][j]) {
						if (i - length >= 0 && i - length < R - 1) {
							picture[i][j] = picture[i-length][j];
							picture[i][j] = '.';
						}
					}
				}
			}

		}
		StringBuilder sb = new StringBuilder();
		for (char[] a : picture) {
			for (char b : a) {
				sb.append(b);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		return;
	}
}
