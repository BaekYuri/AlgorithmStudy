package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14938_서강그라운드 {
	static int N, M, R;
	static int[][] road;
	static int[] item;
	static int value = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		road = new int[N + 1][N + 1];
		item = new int[N+1];
		for(int t=0;t<=N;t++) {
			Arrays.fill(road[t], Integer.MAX_VALUE);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			road[i][i] = 0;
			item[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());

			road[from][to] = Integer.min(length,road[from][to]);
			road[to][from] = Integer.min(length,road[to][from]);
			
		}
		for (int i = 1; i <= N; i++) {//중간에 끼어들 정점

			for (int j = 1; j <=N; j++) {//시작
				for (int k = 1; k <= N; k++) {//도착
					if (i == j || k == i || j == k)
						continue;
					if(road[j][i] == Integer.MAX_VALUE || road[i][k] == Integer.MAX_VALUE) continue;
					road[j][k] = Integer.min(road[j][k], road[j][i] + road[i][k]);
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			int result =item[i];
			for(int j=1;j<=N;j++) {
				if(i==j) {
					continue;
				}
				if(road[i][j]<=M) {
					result+=item[j];
				}
			}
			value= Integer.max(result, value);
		}
		System.out.println(value);

	}

}
