import java.util.Scanner;

public class BOJ_15649_N과M1 {
	static int[] sequence;
	static boolean[] isVisited;
	static StringBuilder sb = new StringBuilder();

	static void getSequence(int start, int to, int count) {
		if (count == 0) {
			for (int a : sequence) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= to; i++) {
			if (!isVisited[i]) {
				sequence[sequence.length - count] = i;
				isVisited[i] = true;
				getSequence(start, to, count - 1);
				isVisited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sequence = new int[M];
		isVisited = new boolean[N + 1];
		getSequence(1, N, M);
		System.out.println(sb);
	}
}
