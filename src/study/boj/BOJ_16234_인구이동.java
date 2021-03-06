package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {
	static int N, L, R;
	static int[][] worlds;
	static int result = 0;
	static int[][] unions;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static List<int[]> link[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		worlds = new int[N][N];
		unions = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {

				worlds[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		setUnion();
		System.out.println(result);
	}

	static void setUnion() {
		while (true) {
			int[][] world = new int[N][N];
			for (int i = 0; i < N; i++) {
				world[i] = worlds[i].clone();
			}
			link = new ArrayList[N][N];
			for (int i = 0; i < N; i++) {
				link[i] = new ArrayList[N];
				for (int j = 0; j < N; j++) {
					link[i][j] = new ArrayList<>();
					for (int k = 0; k < 4; k++) {
						int nr = i + deltas[k][0];
						int nc = j + deltas[k][1];
						if (isIn(nr, nc)) {
							int personDis = Math.abs(world[i][j] - world[nr][nc]);
							if (personDis >= L && personDis <= R) {
								link[i][j].add(new int[] { nr, nc });
							}
						}
					}
				}
			}
			
			boolean[][] visited = new boolean[N][N];
			Queue<int[]> queue = new LinkedList<int[]>();
			int uniNum = 0;
			boolean isDiff =false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j])
						continue;
					queue.clear();
					queue.add(new int[] { i, j });

					uniNum++;
					int peopleNum = 0;
					int nowUnionNum = 0;
					while (!queue.isEmpty()) {
						int[] temp = queue.poll();
						if (visited[temp[0]][temp[1]])
							continue;
						visited[temp[0]][temp[1]] = true;
						peopleNum += world[temp[0]][temp[1]];
						nowUnionNum++;
						unions[temp[0]][temp[1]] = uniNum;
						queue.addAll(link[temp[0]][temp[1]]);
					}
					
					if (nowUnionNum == 1)
						continue;
					if(peopleNum ==0) continue;
					int avg = peopleNum / nowUnionNum;
					isDiff = true;
					for (int k = 0; k < N; k++) {
						for (int l = 0; l < N; l++) {
							if (unions[k][l] == uniNum) {
								
								world[k][l] = avg;
							}
						}
					}
					
					
				}
			}
			if(isDiff) result++;
			
			if (Arrays.deepEquals(worlds, world)) {
				break;
			} else {
				worlds = world;
			}
		}

	}

	

	static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
