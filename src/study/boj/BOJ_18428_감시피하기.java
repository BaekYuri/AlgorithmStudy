package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18428_감시피하기 {
	static int N;
	static char[][] room;
	static int[][] deltas = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static List<int[]> teacher;
	static List<int[]> trap;
	static boolean isCan = false;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		teacher = new ArrayList<>();
		room = new char[N][N];
		trap = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				room[i][j] = st.nextToken().charAt(0);
				if (room[i][j] == 'T') {
					teacher.add(new int[] { i, j });
				} else if (room[i][j] == 'X') {
					trap.add(new int[] { i, j });
				}
			}
		}
		find(3,new int[3],0);

		if (isCan) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
	static void find(int toChoose, int[] choosed, int start) {
		if(isCan) return;
		if (toChoose == 0) {
			char[][] roomCopy = new char[N][N];
			for (int i = 0; i < N; i++) {
				roomCopy[i] = room[i].clone();
			}
			for (int i = 0; i < 3; i++) {
				int[] temp = trap.get(choosed[i]);
				roomCopy[temp[0]][temp[1]] = 'O';
			}
			boolean result = isYES(roomCopy);
			if(result) isCan = true;
			return;
		}
		for (int i = start; i < trap.size(); i++) {
			choosed[choosed.length - toChoose] = i;
			find(toChoose - 1, choosed, i + 1);

		}
	}

	static boolean isYES(char[][] roomCopy) {
		for (int a = 0; a < teacher.size(); a++) {
			int[] temp = teacher.get(a);
			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + deltas[i][0];
				int nc = temp[1] + deltas[i][1];
				
				for (int k = nr, j = nc; isIn(k,j); k += deltas[i][0], j += deltas[i][1]) {
					if (roomCopy[k][j] == 'T' | roomCopy[k][j] == 'O')
						break;
					if (roomCopy[k][j] == 'S') {
						return false;
					}
				}

			}
		}
		return true;
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
