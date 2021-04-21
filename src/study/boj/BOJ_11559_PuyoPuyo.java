package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11559_PuyoPuyo {
	static char[][] map;
	static int[][] deltas = {{0,1},{1,0}};
	static int[][] parents, rank;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 12;
		M = 6;
		map = new char[N][M];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j);
			} 
		}
		int result = 0;
		while(breakBlock()) {
			result++;
			down();
		}
		
		System.out.println(result);
	}
	static boolean breakBlock() {
		make();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int d=0;d<2;d++) {
					int nr = i+deltas[d][0];
					int nc = j+deltas[d][1];
					if(isIn(nr,nc) && map[i][j]==map[nr][nc])
						union(i,j,nr,nc);
				}
				
			}
		}
		int[] count = new int[N*M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				count[find(i,j)]++;
			}
		}
		boolean isBreak = false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]=='.') continue;
				if(count[find(i,j)]>=4) {
					isBreak = true;
					map[i][j] = '.';
				}
				
			}
		}
		return isBreak;
	}
	static void down() {
		
		for(int i=0;i<M;i++) {
			char[] temp = new char[N];
			Arrays.fill(temp, '.');
			for(int j=N-1, t=N-1;j>=0; j--) {
				if(map[j][i]!='.') {
					temp[t--] = map[j][i];
				}
			}
			for(int j=0;j<N;j++) {
				map[j][i] = temp[j];
			}
		}
	}
	static void make() {
		parents = new int[12][6];
		rank = new int[12][6];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				parents[i][j] = i*M + j;
			}
		}
	}
	static int find(int a, int b) {
		if(parents[a][b] == a*M + b) {
			return a*M+b;
		}
		return parents[a][b] = find(parents[a][b]/M,parents[a][b]%M);
	}
	
	static boolean union(int a1, int a2, int b1, int b2) {
		int aRoot = parents[a1][a2];
		int bRoot = parents[b1][b2];
		if(aRoot == bRoot) return false;
		if(rank[aRoot/M][aRoot%M] > rank[bRoot/M][bRoot%M]) {
			parents[bRoot/M][bRoot%M] = parents[aRoot/M][aRoot%M];
		}else {
			parents[aRoot/M][aRoot%M]= parents[bRoot/M][bRoot%M];
			if(rank[aRoot/M][aRoot%M] == rank[bRoot/M][bRoot%M]) {
				rank[bRoot/M][bRoot%M]++;
			}
		}
		return true;
	}
	
	static boolean isIn(int a, int b) {
		return a>=0 && b>= 0 && a<N && b<M;
	}
}
