package study.boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10709_기상캐스터 {
	static int H, W;
	static int left = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		char[][] map = new char[H][W];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < H; i++) {
			s = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		int[][] result = new int[H][W];
		boolean cloud = false;
		int count = 1;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'c') {
					result[i][j] = 0;
				} else {
					count = 1;
					int nr = j - 1;
					cloud = false;
					while (isIn(i, nr)) {
						
						if (map[i][nr] == 'c') {
							cloud = true;
							break;
						}
						nr--;
						count++;

					}

					if (cloud) {
						result[i][j] = count;
					} else {
						result[i][j] = -1;
					}
				}
			}
		}
		for(int i=0;i<H;i++) {
			for(int j=0; j<W;j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	static boolean isIn(int i, int j) {
		return i >= 0 && i < H && j >= 0 && j < W;
	}
}
