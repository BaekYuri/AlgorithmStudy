package study.swea;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class SWEA_1210_Ladder1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map = new int[100][100];

	static int[] now = new int[2];
	static int[] testCase = new int[11];
	public static void main(String[] args) throws NumberFormatException, IOException {
		int tc;
		for (int t = 1; t <= 10; t++) {

			tc = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				String src = br.readLine();
				StringTokenizer st = new StringTokenizer(src);
				int j = 0;
				while (st.hasMoreTokens()) {
					map[i][j] = Integer.parseInt(st.nextToken());
					j++;
				}
			}
			
			for (int i = 0; i < 100; i++) {// 초기 위치 설정
				if (map[99][i] == 2) {

					now[0] = 99;
					now[1] = i;

				}
			}
			while (isIn(now[0], now[1])) {
				if (isIn(now[0], now[1] - 1) && map[now[0]][now[1] - 1] == 1) {
					while (isIn(now[0], now[1] - 1) && map[now[0]][now[1] - 1] == 1) {
						now[1]--;
					}

				} else if (isIn(now[0], now[1] + 1) && map[now[0]][now[1] + 1] == 1) {
					while (isIn(now[0], now[1] + 1) && map[now[0]][now[1] + 1] == 1) {
						now[1]++;
					}

				}
				now[0]--;

			}
			testCase[tc]=now[1];


		}
		for(int i=1;i<=10;i++) {
			System.out.println("#"+i+" "+testCase[i]);
		}
	}

	static boolean isIn(int a, int b) {
		return a >= 0 && a <= 99 && b >= 0 && b <= 99;
	}

}
