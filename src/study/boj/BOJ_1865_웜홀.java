package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865_웜홀 {
	static int N, M, W;
	static int[][] load;
	static boolean result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			load = new int[N + 1][N + 1];
			result = false;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int ss = Integer.parseInt(st.nextToken());
				int ee = Integer.parseInt(st.nextToken());
				int tt = Integer.parseInt(st.nextToken());
				if (load[ss][ee] != 0) {
					load[ss][ee] = Integer.min(tt, load[ss][ee]);
					load[ee][ss] = Integer.min(tt, load[ee][ss]);
				} else {
					load[ss][ee] = tt;
					load[ee][ss] = tt;
				}

			}

			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int ss = Integer.parseInt(st.nextToken());
				int ee = Integer.parseInt(st.nextToken());
				int tt = Integer.parseInt(st.nextToken());
				load[ss][ee] = -tt;
			}
			for (int stt = 1; stt <= N; stt++) {
				if(result) break;
				int[] length = new int[N + 1];
				Arrays.fill(length, 987654321);
				length[stt] = 0;

				for (int i = 1; i <= N; i++) {
					
					for (int a = 1; a <= N; a++) {
						if (load[i][a] != 0) {
							int nr = length[i] + load[i][a];
							length[a] = Integer.min(length[a], nr);
						}
					}
				}
				if(length[stt]<0) {
					result = true;
				}
			}
			if (result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}
