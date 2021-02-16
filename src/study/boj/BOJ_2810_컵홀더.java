package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2810_컵홀더 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();

		s = s.replace("LL", "S");
		if (s.length() + 1 > N) {
			System.out.println(N);
		} else {
			System.out.println(s.length() + 1);
		}
	}
}
