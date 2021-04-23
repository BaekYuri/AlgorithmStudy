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
		
		map = new int[N][N][3];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
				if(map[i][j][0]!=0) {
					map[i][j][1] = 1;
					map[i][j][2] = map[i][j][0];
				}
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
		
		boolean found = false;
		int s=1;
		for(;s<=1000;s++) {
			int[][][] clone = getClone();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j][0]==0) continue;
					int sharkNum = map[i][j][0];
					int sharkDir = nowDirection[sharkNum];
					int noSmell = -1;
					int mySmell = -1;
					for(int d=0;d<4;d++) {
						int direction = priorty[sharkNum][sharkDir][d];
						int nr = i+deltas[direction][0];
						int nc = j+deltas[direction][1];
						if(isIn(nr,nc)) {
							if(map[nr][nc][1]==0 || (map[nr][nc][1]!=0 && map[nr][nc][1]+K<=s)) {
								noSmell = direction;
								break;
							}
							if(map[nr][nc][1]!=0 && map[nr][nc][1]+K>s && map[nr][nc][2]==sharkNum && mySmell == -1) {
								mySmell = direction;
							}
						}
					}
					int togo = -1;
					if(noSmell != -1) {
						togo = noSmell;
					}else if(mySmell != -1) {
						togo = mySmell;
					}
					if(togo != -1) {
						clone[i][j][0] = 0;
						int r = i+deltas[togo][0];
						int c = j+deltas[togo][1];
						if(clone[r][c][0]==0 || clone[r][c][0]>sharkNum) {
							clone[r][c][0] = sharkNum;
							nowDirection[sharkNum] = togo;
						}
					}
					
				}
			}
			map = clone;
			int cnt = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j][0]!=0) {
						cnt++;
						map[i][j][1] = s+1;
						map[i][j][2] = map[i][j][0];
					}
				}
			}
			if(cnt==1) {
				found = true;
				break;
			}
		}
		
		if(found) {
			System.out.println(s);
		}else {
			System.out.println(-1);
		}
	}
	static boolean isIn(int a, int b) {
		return a>=0 && b>=0 && b<N && a<N;
	}
	static int[][][] getClone(){
		int[][][] c = new int[N][N][3];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<3;k++) {
					c[i][j][k] = map[i][j][k];
				}
			}
		}
		return c;
	}
}
