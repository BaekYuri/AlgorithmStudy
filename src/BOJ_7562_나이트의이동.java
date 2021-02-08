import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동 {
	static int[][] direction = { { 1, 2 }, { -1, 2 }, { 1, -2 }, { -1, -2 }, { 2, 1 }, { -2, 1 }, { 2, -1 },
			{ -2, -1 } };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] chess;
	static int I;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			I = Integer.parseInt(br.readLine());
			chess = new int[I][I];

			int[][] fromto = new int[2][2];
			Queue<int[]> queue = new LinkedList<>();
			for (int i = 0; i < 2; i++) {
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s);
				fromto[i][0] = Integer.parseInt(st.nextToken());
				fromto[i][1] = Integer.parseInt(st.nextToken());
			}
			for (int[] a : chess) {
				Arrays.fill(a, -1);
			}
			chess[fromto[1][0]][fromto[1][1]] = 0;
			queue.add(new int[] {fromto[1][0], fromto[1][1]});	
			int distance = 1;
			outer: while (!queue.isEmpty()) {
				int[] now = queue.poll();
				for (int i = 0; i < 8; i++) {
					int ni = now[0] + direction[i][0];
					int nj = now[1] + direction[i][1];
					if (isIn(ni, nj)) {
						if (chess[ni][nj] == -1) {
							chess[ni][nj] = chess[now[0]][now[1]] + distance;
						}else { //방문했다면 그냥 넘어가기
							continue;
						}
						if (ni == fromto[0][0] && nj == fromto[0][1]) {
							break outer;
						}
						queue.offer(new int[] { ni, nj });
					}
				}
			}
			
			System.out.println(chess[fromto[0][0]][fromto[0][1]]);
		}
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && x < I && y >= 0 && y < I;
	}
}
