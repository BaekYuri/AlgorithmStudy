import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭 {
	static int[] cards;
	static int N, M;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		combination(3, 0, 0);
		
		
		System.out.println(max);
	}

	static void combination(int toChoose, int startIdx, int score) {
		if (max == M || score>M) {
			return;
		}
		if (toChoose == 0) {
			if (score <= M) {
				max = Integer.max(max, score);
			}
			return;
		}
		for (int i = startIdx; i < cards.length; i++) {
			combination(toChoose - 1, i + 1, score + cards[i]);
		}
	}
}
