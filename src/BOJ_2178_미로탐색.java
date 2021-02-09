import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
	static int N, M;
	static int[][] direction = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] miro = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			s = br.readLine();
			for (int j = 0; j < M; j++) {
				char temp = s.charAt(j);
				if (temp == '0') {
					visited[i][j] = true;
				}
			}
		}
		miro[0][0] = 1;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });
		outer: while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			if(visited[temp[0]][temp[1]]) continue; //방문했던 곳은 아래거 수행하지 말고 꼭 그냥 넘어가자!
			visited[temp[0]][temp[1]] = true;
			for (int i = 0; i < 4; i++) {
				int ni = temp[0] + direction[i][0];
				int nj = temp[1] + direction[i][1];
				if (isIn(ni, nj) && !visited[ni][nj]) {
					miro[ni][nj] = miro[temp[0]][temp[1]] + 1;
					if (ni == N - 1 && nj == M - 1) {
						break outer;
					}
					queue.add(new int[] { ni, nj });

				}
			}
		}
		System.out.println(miro[N - 1][M - 1]);
	}

	static boolean isIn(int a, int b) {
		return a >= 0 && a < N && b >= 0 && b < M;
	}
}
