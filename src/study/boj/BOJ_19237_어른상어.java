package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19237_어른상어 {
	static int N, M, K;
	static int[][][] map;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static int[][][] priorty;
	static int[] nowDirection;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());//격자 N*N
		M = Integer.parseInt(st.nextToken());//상어의 수
		K = Integer.parseInt(st.nextToken());//향기가 남는 시간
		
		map = new int[N][N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
			}
		}
		nowDirection = new int[M+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=M;i++) {
			nowDirection[i] = Integer.parseInt(st.nextToken())-1;
		}
		priorty = new int[M+1][4][4];
		for(int i=1;i<=M;i++) {
			for(int j=0;j<4;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<4;k++) {
					priorty[i][j][k] = Integer.parseInt(st.nextToken())-1;
				}
			}
		}
		
		
	}
}
