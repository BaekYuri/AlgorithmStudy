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


		if (count != 0) {

			int length = Integer.MAX_VALUE;
			int[][] locate = new int[C][2];
			for (int j = 0; j < C; j++) {//각 열마다 유성의 끝점과 땅의 시작점 구하기
				locate[j][0] = -1;
				locate[j][1] = R - 1;
				for (int i = 0; i < R; i++) {
					if (picture[i][j] == '#') {
						locate[j][1] = i;
						break;
					}
					if (picture[i][j] == 'X') {
						locate[j][0] = i;

					}
				}
				if (locate[j][0] == -1) {
					continue;
				}

				length = Integer.min(length, locate[j][1] - locate[j][0]);

			}
			length--;
			if (length != 0) {
				for (int j = 0; j < C; j++) {
					if(locate[j][0]==-1) continue;//그 열에 유성이 없다면 넘어가기
					for (int i = locate[j][0]; i >= 0; i--) {
						picture[i + length][j] = picture[i][j];//땅과 유성의 최소거리만큼 옮기기
						picture[i][j] = '.';
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
