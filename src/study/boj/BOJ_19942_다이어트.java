package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_19942_다이어트 {
	static int N;
	static int[] minValue;
	static int[][] foods;
	
	static int money;
	static boolean[] choosed;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		input();
		
		
		powerset(new boolean[N], 0, 0, 0, 0, 0,0);
		
		StringBuilder sb = new StringBuilder();
		if(choosed==null) {
			sb.append(-1);
		}else {
			sb.append(money).append("\n");
			for(int i=0;i<N;i++) {
				if(choosed[i]) {
					sb.append(i+1).append(" ");
				}
			}
		}
		System.out.println(sb);
	}

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		minValue = new int[4];
		for (int i = 0; i < 4; i++) {
			minValue[i] = Integer.parseInt(st.nextToken());
		}

		foods = new int[N][5];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				foods[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		money = Integer.MAX_VALUE;
	}
	
	static void powerset(boolean[] visited, int idx, int p, int f, int s, int v, int m) {
		if(money<=m) {
			return;
		}
		if(p>=minValue[0] && f>=minValue[1] && s>=minValue[2] && v>=minValue[3]) {
			if(money>m) {
				money = m;
				choosed = visited.clone();
			}
			return;
		}
		if(idx==N) {
			return;
		}
		
		visited[idx] = true;
		powerset(visited, idx+1, p+foods[idx][0], f+foods[idx][1], s+foods[idx][2], v+foods[idx][3], m+foods[idx][4]);
		visited[idx] = false;
		powerset(visited, idx+1,p,f,s,v,m);
	}
}
