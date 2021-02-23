package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1247_최적경로 {
	static int customer;
	static int[] workspace, home;
	static int[][] cusHome;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			customer = Integer.parseInt(br.readLine());
			cusHome = new int[customer][2];
			workspace = new int[2];
			home = new int[2];
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			workspace[0] = Integer.parseInt(st.nextToken());
			workspace[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < customer; i++) {
				cusHome[i][0] = Integer.parseInt(st.nextToken());
				cusHome[i][1] = Integer.parseInt(st.nextToken());
			}

			permutation(customer, new boolean[customer], 0, new int[customer]);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	static void permutation(int toChoose, boolean[] visited, int leng, int[] choosed) {
		if(leng>min) return;
		if (toChoose == 0) {
			leng+=  Math.abs(home[0] - cusHome[choosed[choosed.length - 1]][0])
					+ Math.abs(home[1] - cusHome[choosed[choosed.length - 1]][1]);
			
			min = Integer.min(min, leng);
			return;
		}
		for (int i = 0; i < customer; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			choosed[choosed.length-toChoose]=i;
			int temp = 0;
			if(choosed.length-toChoose==0) {
				temp =  Math.abs(workspace[0] - cusHome[choosed[0]][0]) + Math.abs(workspace[1] - cusHome[choosed[0]][1]);
			}else {
				temp = Math.abs(cusHome[choosed[choosed.length-toChoose]][0] - cusHome[choosed[choosed.length-toChoose-1]][0])
						+ Math.abs(cusHome[choosed[choosed.length-toChoose]][1] - cusHome[choosed[choosed.length-toChoose-1]][1]);
			}
			permutation(toChoose - 1, visited, leng + temp, choosed);
			
			visited[i] = false;
			
			
		}
	}

}
