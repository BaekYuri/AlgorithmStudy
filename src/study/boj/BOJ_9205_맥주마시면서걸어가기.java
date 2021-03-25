package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		for (int t = 0; t < T; t++) {
			int shop = Integer.parseInt(br.readLine());

			int[][] point = new int[shop + 2][2];
			for (int i = 0; i < shop + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				point[i][0] = Integer.parseInt(st.nextToken());
				point[i][1] = Integer.parseInt(st.nextToken());
			}
			int[][] distance = new int[shop + 2][shop + 2];
			for (int i = 0; i < shop + 2; i++) {
				for (int j = i + 1; j < shop + 2; j++) {
					int temp = Math.abs(point[i][0] - point[j][0]) + Math.abs(point[i][1] - point[j][1]);
					if(temp%50!=0) {
						distance[i][j] = (temp/50)+1;
					}else {
						distance[i][j] = temp/50;
					}
					distance[i][j]-=20;
					if(distance[i][j]<0) distance[i][j] = 0;
					distance[j][i] = distance[i][j];
				}
			}
			int N =shop+2;
			for (int k = 0; k < N; k++) {

				for (int i = 0; i < N; i++) {
					if (k == i)
						continue;
					for (int j = 0; j < N; j++) {
						if (k == j || i == j)
							continue;
						distance[i][j] = Integer.min(distance[i][j], distance[i][k] + distance[k][j]);
					}
				}

			}
			if(distance[0][N-1]<=0) {
				sb.append("happy").append("\n");
			}else {
				sb.append("sad").append("\n");
			}
		}
		System.out.println(sb);
	}
}
