package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	static int N, M;
	static int[][] space;
	static int time=0,cheeseNum=0, lastCheese;
	static boolean[][] air;
	static int[][] deltas= {{0,1},{1,0},{0,-1},{-1,0}};
	static int[] parents, rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		space= new int[N][M];
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if(space[i][j]==1) cheeseNum++;
			}
		}
		while(cheeseNum>0) {
			melt();
			time++;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(time).append("\n").append(lastCheese);
		System.out.println(sb);
		return;
	}
	static void findAir() {
		air = new boolean[N][M];
		make();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				for(int d=0;d<2;d++) {
					
					int nr = i+deltas[d][0];
					int nc = j+deltas[d][1];
					if(isIn(nr,nc) && space[i][j]==space[nr][nc]) {
						union(i*M+j,nr*M+nc);
					}
					
				}
				
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(find(i*M+j)==find(0)) {
					air[i][j]= true;
				}
			}
		}
	}
	static void melt() {
		findAir();
		lastCheese = cheeseNum;
		boolean[][] toDelete = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(space[i][j]==0) continue;
				boolean isAir = false;
				for(int d=0;d<4;d++) {
					
					int nr = i+deltas[d][0];
					int nc = j+deltas[d][1];
					
					if(air[nr][nc]) {
						isAir = true;
						break;
					}
				}
				if(isAir) {
					toDelete[i][j] = true;
				}
				
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(toDelete[i][j]) {
					space[i][j]=0;
					cheeseNum--;
				}
			}
		}
		
	}
	static boolean isIn(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}
	static void make() {
		parents = new int[N*M];
		rank = new int[N*M];
		for(int i=0;i<N*M;i++) {
			parents[i] = -1;
		}
	}
	static int find(int a) {
		if(parents[a] < 0) {
			return a;
		}else {
			return parents[a] = find(parents[a]);
		}
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return false;
		}
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
