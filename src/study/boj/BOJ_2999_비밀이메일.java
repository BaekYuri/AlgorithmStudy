package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2999_비밀이메일 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		int length = s.length();
		int r = 1, c = length;
		for (int i = 2; i <= length; i++) {
			if (length % i == 0) {
				if (i <= length / i) {
					r = i;
					c = length / i;
				} else {
					break;
				}
			}
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				sb.append(s.charAt(r*j+i));

			}
		}

		System.out.println(sb);
	}
}
