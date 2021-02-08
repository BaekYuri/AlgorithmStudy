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

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] miro = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		boolean[][] copy = new boolean[N][M];
		Queue<int[]> queue[][] = new LinkedList[N][M];
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			queue[i] = new LinkedList[M];
			for (int j = 0; j < M; j++) {
				queue[i][j] = new LinkedList<>();
				int temp = s.charAt(j) - '0';
				if (temp == 0) {
					visited[i][j] = true;
					copy[i][j] = true;
				}
			}
		}
		Queue<int[]> line = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!copy[i][j]) {
					copy[i][j] = true;
					for (int k = 0; k < 4; k++) {
						int ni = i + direction[k][0];
						int nj = j + direction[k][1];
						if (isIn(ni, nj) && !copy[ni][nj]) {
							queue[i][j].offer(new int[] { ni, nj });
						}
					}
				}
			}
		}
		Stack<int[]> stack = new Stack<>();

		line.offer(new int[] { 0, 0 });

		while (!line.isEmpty()) {
			int[] temp = line.poll();
			
			visited[temp[0]][temp[1]] = true;
			
			if (temp[0] == N - 1 && temp[1] == M - 1) {
				break;
			}

			if (queue[temp[0]][temp[1]].size() > 1) {
				stack.push(new int[] { temp[0], temp[1] });
			}
			if (queue[temp[0]][temp[1]].isEmpty()) {
				int[] temp3 = stack.pop();
				line.offer(temp3);
				visited[temp3[0]][temp3[1]]= false;
			} else {
				
				int[] temp2 = queue[temp[0]][temp[1]].poll();
				miro[temp2[0]][temp2[1]] = miro[temp[0]][temp[1]] + 1;
				line.offer(temp2);
			}
			

		}
		System.out.println(miro[N - 1][M - 1] + 1);
	}

	static boolean isIn(int a, int b) {
		return a >= 0 && a < N && b >= 0 && b < M;
	}
}
