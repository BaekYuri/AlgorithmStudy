package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int now = (int) Math.pow(2, N);
		int from = 0;
		do {
			int temp = now / 2;
			if (r >= temp) {
				from = from + temp * now;
				r -= temp;
			}
			if (c >= temp) {
				from = from + temp * temp;
				c -= temp;
			}
			now /= 2;
		} while (r != 0 || c != 0);

		System.out.println(from);
	}
}
