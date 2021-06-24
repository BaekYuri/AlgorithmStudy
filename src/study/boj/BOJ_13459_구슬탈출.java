package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13459_구슬탈출 {
	static int N, M;
	static char[][] map;
	static int[] red;
	static int[] blue;
	static int[][] deltas = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static boolean found = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		red = new int[2];
		blue = new int[2];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);

				if (map[i][j] == 'R') {
					red[0] = i;
					red[1] = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					blue[0] = i;
					blue[1] = j;
					map[i][j] = '.';
				}
			}
		}
		dfs(0, red, blue);
		
		System.out.println(found?1:0);
	}

	static void dfs(int depth, int[] red, int[] blue) {
		if (found)
			return;
		if (Arrays.equals(red, blue))
			return;
		if (depth > 10)
			return;
		if (map[blue[0]][blue[1]] == 'O')
			return;
		if (map[red[0]][red[1]] == 'O') {
			found = true;
			return;
		}
		int[] nowRed = red.clone();
		int[] nowBlue = blue.clone();
		for (int d = 0; d < 4; d++) {
			int[] first = nowRed;
			int[] second = nowBlue;
			
			
			switch (d) {
			case 0:
				first = nowBlue[0] > nowRed[0] ? nowBlue : nowRed;
				second = nowBlue[0] > nowRed[0] ? nowRed : nowBlue;
				break;
			case 1:
				first = nowBlue[1] > nowRed[1] ? nowBlue : nowRed;
				second = nowBlue[1] > nowRed[1] ? nowRed : nowBlue;
				break;
			case 2:
				first = nowBlue[0] <= nowRed[0] ? nowBlue : nowRed;
				second = nowBlue[0] <= nowRed[0] ? nowRed : nowBlue;
				break;
			case 3:
				first = nowBlue[1] <= nowRed[1] ? nowBlue : nowRed;
				second = nowBlue[1] <= nowRed[1] ? nowRed : nowBlue;
				break;
			}

			while (true) {
				int nr = first[0] + deltas[d][0];
				int nc = first[1] + deltas[d][1];

				if (map[nr][nc] == '#') {
					break;
				}
				first[0] = nr;
				first[1] = nc;
				if (map[nr][nc] == 'O') {
					break;
				}
			}
			while(true) {
				int nr = second[0] + deltas[d][0];
				int nc = second[1] + deltas[d][1];

				if (map[nr][nc] == '#') {
					break;
				}
				if(map[nr][nc]!='O' && first[0]==nr && first[1]==nc) {
					break;
				}
				second[0] = nr;
				second[1] = nc;
				if (map[nr][nc] == 'O') {
					break;
				}
			}
			
			dfs(depth+1, nowRed, nowBlue);
			
			nowRed = red.clone();
			nowBlue = blue.clone();
		}

	}
}
