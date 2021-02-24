package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {
	static int[][] paper;
	static int N;
	static int result[] = new int[3];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (N == 1) {
			result[paper[0][0] + 1]++;
		} else {
			search(N, 0, 0);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(result[0]).append("\n").append(result[1]).append("\n").append(result[2]).append("\n");

		System.out.println(sb);
	}

	static void search(int length, int startR, int startC) {
		if (length == 1) {
			int first = paper[startR][startC];
			boolean isSame = true;
			outer : for (int i = startR; i < startR + 3; i++) {
				for (int j = startC; j < startC + 3; j++) {
					if (paper[i][j] != first) {
						isSame = false;
						break outer;
					}
					
				}
			}
			if(isSame) {
				result[first+1]++;
			}else {
				for (int i = startR; i < startR + 3; i++) {
					for (int j = startC; j < startC + 3; j++) {
							result[paper[i][j]+1]++;
					}
				}
			}
			return;
		}
		boolean isAllSame = true;
		int allFirst = paper[startR][startC];
		for (int i = startR; i < startR + length; i += (length / 3)) {

			for (int j = startC; j < startC + length; j += (length / 3)) {
				int first = paper[i][j];
				boolean isSame = true;
				outer: for (int k = i; k < i + (length / 3); k++) {
					for (int l = j; l < j + (length / 3); l++) {
						if (paper[k][l] != first) {
							isSame = false;
							break outer;
						}
					}
				}
				if (isSame) {
					result[first + 1]++;
				} else {
					search((length / 3), i, j);
					isAllSame = false;
				}

			}
		}
		if(isAllSame) {
			result[allFirst+1] -=8;
		}
	}
}
