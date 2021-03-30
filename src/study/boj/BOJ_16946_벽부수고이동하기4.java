package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16946_벽부수고이동하기4 {
	static int N, M;
	static int[][] map;
	static int[] parents, rank;
	static int[][] deltas = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		int count[] = new int[N*M];
		for(int i=0;i<N;i++) {
			String s= br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		make();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1) continue;
				for(int d=0;d<2;d++) {
					int nr = i+deltas[d][0];
					int nc = j+deltas[d][1];
					if(isIn(nr,nc) && map[nr][nc]==0) {
						union(i*M+j, nr*M+nc);
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				count[find(i*M+j)]++;
			}
		}
		
		int result[][] = new int[N][M];
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) continue;
				result[i][j]=1;
				list.clear();
				for(int d=0;d<4;d++) {
					int nr = i+deltas[d][0];
					int nc = j+deltas[d][1];
					if(isIn(nr,nc) && map[nr][nc]==0) {
						int tmp = find(nr*M+nc);
						if(!list.contains(tmp)) {
							result[i][j]+=count[tmp];
							list.add(tmp);
						}
					}
				}
				result[i][j]%=10;
			}
		}
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(result[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void make() {
		parents = new int[N*M];
		rank = new int[N*M];
		for(int i=0;i<N*M;i++) {
			parents[i] = i;
		}
	}
	static int find(int a) {
		if(parents[a]==a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		if(rank[aRoot]>rank[bRoot]) {
			parents[bRoot]=aRoot;
		}else {
			parents[aRoot]=bRoot;
			if(rank[aRoot]==rank[bRoot]) {
				rank[bRoot]++;
			}
		}
		return true;
	}
	
	static boolean isIn(int a, int b) {
		return a>=0 && b>=0 && a<N && b<M;
	}
}
