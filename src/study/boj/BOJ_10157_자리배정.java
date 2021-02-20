package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10157_자리배정 {
	static int N, M;
	static int[][] room;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int find = Integer.parseInt(br.readLine());
		if(find>N*M) {
			System.out.println(0);
			return;
		}
		room = new int[N][M];
		int nowN =0;
		int nowM =0;
		int nowDeltas = 0;
		room[0][0] = 1;
		for(int i=2;i<=find;i++) {
			int nn = nowN+ deltas[nowDeltas][0];
			int nm = nowM+ deltas[nowDeltas][1];
			if(isIn(nn,nm) && room[nn][nm]==0) {
				room[nn][nm] = i;
				nowN = nn;
				nowM = nm;
			}else {
				nowDeltas= (nowDeltas+1)%4;
				i--;
			}	
		}
		StringBuilder sb = new StringBuilder();
		sb.append(nowN+1).append(" ").append(nowM+1);
		System.out.println(sb);
	}
	static boolean isIn(int n,int m) {
		return n>=0 && n<N && m>=0 && m<M;
	}
}
