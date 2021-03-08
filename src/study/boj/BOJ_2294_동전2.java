package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294_동전2 {
	static int n, k;
	static int[] coin;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		coin = new int[n];
		for(int i=0;i<n;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[k + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i=1;i<k+1;i++) {
			for(int j=0;j<n;j++) {
				if(isIn(i-coin[j])&&dp[i-coin[j]]!=Integer.MAX_VALUE) {
					dp[i]= Integer.min(dp[i-coin[j]]+1, dp[i]);
				}
			}
		}
		if(dp[k]==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(dp[k]);
		}
	}
	static boolean isIn(int a) {
		return a>=0 && a<=k;
	}
}
