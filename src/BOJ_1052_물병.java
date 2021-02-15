import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1052_물병 {
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if (N <= K) {
			System.out.println(result);
			return;
		}
		String now = Integer.toBinaryString(N);
		int nowCount = 0;
		for(int i=0;i<now.length();i++) {
			if(now.charAt(i)=='1') {
				nowCount++;

			}
		}
		while(nowCount>K) {
			N++;
			result++;
			now = Integer.toBinaryString(N);
			nowCount = 0;
			for(int i=0;i<now.length();i++) {
				if(now.charAt(i)=='1') {
					nowCount++;
				}
			}
		}

		System.out.println(result);
	}
}
