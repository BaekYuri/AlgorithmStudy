package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1080_행렬 {
	static int N, M;
	static char[][] A, B;
	static boolean[][] isSame;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new char[N][M];
		B = new char[N][M];
		isSame = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				B[i][j] = s.charAt(j);
				if (A[i][j] == B[i][j]) {
					isSame[i][j] = true;
				}
			}
		}
		if(Arrays.deepEquals(A, B)) {
			System.out.println(0);
			return;
		}
		if (N < 3 || M < 3) {
			System.out.println(-1);
			return;
		}
		
		int changedCnt = 0;

		for (int i = 0; i <= N - 3; i++) {
			for (int j = 0; j <= M - 3; j++) {
				if(!isSame[i][j]) {
					change(i, j);
					changedCnt++;
				}
			}
		}
		boolean[][] trues = new boolean[N][M];
		for(int t=0;t<N;t++) {
			Arrays.fill(trues[t], true);
		}
		if(Arrays.deepEquals(isSame, trues)) {
			System.out.println(changedCnt);
		}else {
			System.out.println(-1);
		}
		
	}

	static void change(int i, int j) {
		for (int a = i; a < i + 3; a++) {
			for (int b = j; b < j + 3; b++) {
				isSame[a][b] = !isSame[a][b];
			}
		}
	}

}
