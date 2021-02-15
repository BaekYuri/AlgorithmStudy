import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] taste;
	static int minValue = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		taste = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}
		powerset(0, N);
		System.out.println(minValue);
	}

	static void powerset(int choosed, int toChoose) {
		if (toChoose == 0) {
			if (choosed != 0) {
				int sour = 1, bitter = 0;
				for (int i = 0; i < taste.length; i++) {
					if ((choosed & 1 << i) != 0) {
						sour *= taste[i][0];
						bitter += taste[i][1];
					}
				}
				minValue = Integer.min(minValue, Math.abs(sour - bitter));

			}
			return;
		}
		powerset(choosed | (1 << (taste.length - toChoose)), toChoose - 1);
		powerset(choosed, toChoose - 1);
	}
}
