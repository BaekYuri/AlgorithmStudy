package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17943_도미노예측 {
	static int N, Q;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr= new int[N];
		int[] dp = new int[N+1]; //1번째 값에서 N번쨰 값을 xor 한 값 dp
		for(int i=1;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		dp[2] = arr[1];
		for(int i=3;i<=N;i++) {
			dp[i] = arr[i-1]^dp[i-1];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<Q;t++) {
			st = new StringTokenizer(br.readLine());
			int qNum = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			switch(qNum) {
			case 0:// x^y = (1^x)^(1^y)
				sb.append(dp[x]^dp[y]).append("\n");
				break;
			case 1:
				int d= Integer.parseInt(st.nextToken());
				sb.append(dp[x]^dp[y]^d).append("\n");
				break;
			}
			
		}
		System.out.println(sb);
	}
}
