package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_20058_마법사상어와파이어스톰 {
	static int N, Q, length;
	static int[][] A;
	static int[] parents, rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		length = (int) Math.pow(2, N);

		A = new int[length][length];

		for (int i = 0; i < length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < length; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<Q;i++) {
			fireStorm(Integer.parseInt(st.nextToken()));
		}
		int sum = 0;
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				sum+=A[i][j];
			}
		}
		int max = kanNum();
		StringBuilder sb = new StringBuilder();
		sb.append(sum).append("\n").append(max).append("\n");
		System.out.println(sb);
		return;

	}
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void fireStorm(int level) {
		int lvLength = (int) Math.pow(2, level);
		for (int i = 0; i < A.length; i += lvLength) {
			for (int j = 0; j < A.length; j += lvLength) {

				int[][] tempArr = new int[lvLength][lvLength];
				for(int a=0, t=i;a<lvLength;a++, t++) {
					tempArr[a] = Arrays.copyOfRange(A[t],j, j+lvLength);
				}
				
				for(int a=i, r=0;a<i+lvLength;a++, r++) {
					for(int b=j, c=lvLength-1;b<j+lvLength;b++, c--) {
						A[a][b] = tempArr[c][r];
					}
				}

			}
		}
		boolean[][] ice= new boolean[length][length];
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<A.length;j++) {
				if(A[i][j]<=0) continue;
				int cnt =0;
				for(int d=0;d<4;d++) {
					int nr = i+deltas[d][0];
					int nc = j+deltas[d][1];
					if(isIn(nr,nc) && A[nr][nc]>0) {
						cnt++;
					}
				}
				if(cnt<3) ice[i][j]=true;
			}
		}
		
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<A.length;j++) {
				if(ice[i][j]) {
					A[i][j]--;
				}
			}
		}
	}
	static int kanNum() {
		make();
		boolean isEmpty = true;
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				if(A[i][j]<=0) continue;
				isEmpty = false;
				for(int d=0;d<4;d++) {
					int nr = i+deltas[d][0];
					int nc = j+deltas[d][1];
					if(isIn(nr,nc) && A[nr][nc]>0) {
						union((i*length)+j, (nr*length)+nc);
					}
				}
				
			}
		}
		if(isEmpty) return 0;
		int temp[] = new int[length*length];
		int max = 0;
		for(int i=0;i<length*length;i++) {
			int pr = find(i);
			temp[pr]++;
			max = Integer.max(max, temp[pr]);
		}
		
		return max;
		
	}
	static boolean isIn(int a, int b) {
		return a>=0 && a<A.length && b>=0 && b<A.length;
	}

	
	static void make() {
		parents = new int[length*length];
		rank = new int[length*length];
		for(int i=0;i<parents.length;i++) {
			parents[i] = -1;
		}
	}
	static int find(int n) {
		if(parents[n]==-1) {
			return n;
		}
		return parents[n] = find(parents[n]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot ==bRoot) return false;
		if(rank[aRoot]>rank[bRoot]) {
			parents[bRoot] = aRoot;
		}else {
			parents[aRoot] = bRoot;
			if(rank[aRoot]==rank[bRoot]) {
				rank[bRoot]++;
			}
		}
		return true;
	}
}
