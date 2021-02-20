package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15240_Paintbucket {
	static int[][] drawing;
	static int N, M;

	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		LinkedList<int[]> link[][] = new LinkedList[N][M];
		drawing = new int[N][M];
		for (int n = 0; n < N; n++) {
			String s = br.readLine();
			link[n] = new LinkedList[M];
			for (int m = 0; m < M; m++) {
				link[n][m] = new LinkedList<>();
				drawing[n][m] = s.charAt(m) - '0';
			}
		}

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				for (int k = 0; k < 4; k++) {
					int nr = n + deltas[k][0];
					int nc = m + deltas[k][1];
					if (isIn(nr, nc) && drawing[n][m] == drawing[nr][nc]) {
						link[n][m].add(new int[] { nr, nc });
					}
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int nowX = Integer.parseInt(st.nextToken());
		int nowY = Integer.parseInt(st.nextToken());
		int fill = Integer.parseInt(st.nextToken());

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { nowX, nowY });
		boolean[][] visited = new boolean[N][M];
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			if(visited[temp[0]][temp[1]]) continue;
			visited[temp[0]][temp[1]] = true;
			drawing[temp[0]][temp[1]] = fill;
			while(!link[temp[0]][temp[1]].isEmpty()) {
				queue.add(link[temp[0]][temp[1]].poll());
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int[] a: drawing) {
			for(int b : a) {
				sb.append(b);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		return;
	}

	static boolean isIn(int a, int b) {
		return a >= 0 && a < N && b >= 0 && b < M;
	}
}
