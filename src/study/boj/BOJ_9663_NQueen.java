package study.boj;

import java.util.Scanner;

public class BOJ_9663_NQueen {
	static int result;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] map = new int[N];
		result = 0;
		find(map, N, N, new boolean[N]);
		System.out.println(result);
	}

	private static void find(int[] map, int n, int size, boolean[] col) {
		if (n == 0) {
			result++;
			return;
		}
		int i = size - n;
		for(int x=0; x<size; x++) {
			if(col[x]) continue;
			boolean found = false;
			for(int y=0; y<i; y++) {
				if(Math.abs(i-y)==Math.abs(x-map[y])) {
					found = true;
					break;
				}
			}
			if(!found) {
				map[i] = x;
				col[x] = true;
				find(map, n-1, size, col);
				col[x] = false;
			}
		}

	}



}
