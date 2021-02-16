package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294_동전2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[k + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int[] price = new int[n];
		for (int a = 0; a < n; a++) {
			price[a] = Integer.parseInt(br.readLine());
			boolean[] visited = new boolean[k+1];
			for (int i = 0; i <= k; i++) {
				if (dp[i] == Integer.MAX_VALUE || visited[i])
					continue;
				for (int j = 1; i + j * price[a] <= k; j++) {
					visited[i + j * price[a]] =true;
					dp[i + j * price[a]] = Integer.min(dp[i + j * price[a]-price[a]]+1, dp[i] + j);

				}
			}
		}
		int result = dp[k];
		System.out.println(result);
	}
}
