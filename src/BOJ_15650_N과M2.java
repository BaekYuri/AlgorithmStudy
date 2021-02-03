import java.util.Scanner;

public class BOJ_15650_N과M2 {
	static int[] sequence;
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
			sequence[sequence.length - count] = i;
			getSequence(i + 1, to, count - 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sequence = new int[M];
		getSequence(1, N, M);
		System.out.println(sb);
	}
}
