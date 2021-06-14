package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4335_무인도탈출 {
	static int N;
	static int[][] block;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			
			block = new int[N][3];
			
			max = 0;
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<3;j++) {
					block[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			permutation(0,10000,10000,0,new boolean[N]);
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
	static void permutation(int idx, int x, int y, int z, boolean visited[]) {
		if(idx == N) {
			max = Math.max(max, z);
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			if((block[i][0]<=x && block[i][1]<=y) || (block[i][1]<=x && block[i][0]<=y)) {
				permutation(idx+1,block[i][0],block[i][1],z+block[i][2],visited);
			}
			if((block[i][0]<=x && block[i][2]<=y) ||(block[i][2]<=x && block[i][0]<=y)) {
				permutation(idx+1,block[i][0],block[i][2],z+block[i][1],visited);
			}
			if((block[i][1]<=x && block[i][2]<=y) || (block[i][2]<=x && block[i][1]<=y)) {
				permutation(idx+1,block[i][1],block[i][2],z+block[i][0],visited);
			}
			permutation(idx+1,x,y,z,visited);
			visited[i] = false;
		}
	}
}
