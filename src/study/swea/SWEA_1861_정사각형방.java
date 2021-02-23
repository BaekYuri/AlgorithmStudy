package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1861_정사각형방 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] room;
	static boolean[][] visited;
	static int cnt = 0;
	static int[][] roomValue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			roomValue = new int[N][N];
			String s;
			StringTokenizer st;
			for (int i = 0; i < room.length; i++) {
				s = br.readLine();
				st = new StringTokenizer(s);
				for (int j = 0; j < room[i].length; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			visited = new boolean[N][N];

			int maxCnt = Integer.MIN_VALUE;

			int nowNumber = Integer.MAX_VALUE;
			for (int i = 0; i < room.length; i++) {
				for (int j = 0; j < room.length; j++) {
					searchRoom(i, j, 1);
					if (roomValue[i][j] > maxCnt) {
						maxCnt = Integer.max(maxCnt, roomValue[i][j]);
						nowNumber = room[i][j];

					} else if (roomValue[i][j] == maxCnt) {
						nowNumber = Integer.min(room[i][j], nowNumber);
					}

				}
			}


			sb.append("#").append(t).append(" ").append(nowNumber).append(" ").append(maxCnt).append("\n");

		}
		System.out.println(sb);
	}

	static void searchRoom(int i, int j, int count) {
		if (!isIn(i, j)) {

			
			return;

		}
		if(visited[i][j]) {
			return;
		}
		int ni = i, nj = j;
		if (isIn(i - 1, j) && room[i][j] == room[i - 1][j] - 1) {
			ni = i - 1;
		} else if (isIn(i + 1, j) && room[i][j] == room[i + 1][j] - 1) {
			ni = i + 1;
		} else if (isIn(i, j - 1) && room[i][j] == room[i][j - 1] - 1) {
			nj = j - 1;

		} else if (isIn(i, j + 1) && room[i][j] == room[i][j + 1] - 1) {
			nj = j + 1;
		}
		visited[i][j] = true;
		if (i != ni || j != nj) {
			

			searchRoom(ni, nj, 1);
			count+=roomValue[ni][nj];

		}

		roomValue[i][j]=count;
		
	}

	static boolean isIn(int a, int b) {
		return a >= 0 && a < room.length && b >= 0 && b < room.length;
	}
}
