package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1106_호텔 {
	static List<Integer> city;
	static int C, N;
	static int minValue = Integer.MAX_VALUE;
	static Map<Integer, Integer> cityMap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());// 최소 인원
		N = Integer.parseInt(st.nextToken());// 도시 개수
		int[] dp = new int[2001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		city = new ArrayList<Integer>();
		cityMap = new HashMap<>();
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int b =  Integer.parseInt(st.nextToken()); // 고객을 모으는 비용 : value
			int a =  Integer.parseInt(st.nextToken()); // 고객의 수 : key

			
			for(int j=0;j<=2000;j++) {
				if(dp[j]== Integer.MAX_VALUE) continue;
				for(int k=0;j+k*a<=2000;k++) {
					dp[j+k*a] = Integer.min(dp[j+k*a], dp[j]+k*b);
				}
			}
			
		}
		
		for(int i=C;i<=2000;i++) {
			minValue = Integer.min(minValue, dp[i]);
		}

		System.out.println(minValue);
	}

}
