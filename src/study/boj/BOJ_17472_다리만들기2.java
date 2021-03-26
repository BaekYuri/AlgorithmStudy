package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17472_다리만들기2 {
	static int N, M;
	static int[][] map;
	static int[] parents, rank;
	static int[][] deltas= {{0,1},{1,0},{0,-1},{-1,0}};
	static PriorityQueue<int[]> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		make();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				for(int d=0;d<4;d++) {
					int nr = i+deltas[d][0];
					int nc = j+deltas[d][1];
					if(isIn(nr,nc) && map[i][j]==map[nr][nc]) {
						union(i*M+j,nr*M+nc);
					}
				}
			}
		}
		queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[2], o2[2]);
			}
		});
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) continue;
				for(int d=0;d<4;d++) {
					int depth = 1;
					int nr=0, nc=0;
					boolean found = false;
					
					while(true){
						nr = i+deltas[d][0]*depth;
						nc = j+deltas[d][1]*depth;
						if(isIn(nr,nc)) {
							if(map[nr][nc]==1) {
								if(find(i*M+j)!=find(nr*M+nc)) {
									found = true;	
								}
								break;
							}
						}else {
							break;
						}
						depth++;
					}
					if(depth>=3 && found) {
						queue.add(new int[] {find(i*M+j),find(nr*M+nc),depth-1});
					}
				}
				
			}
		}
		
		int result = 0;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			if(union(temp[0],temp[1])) {
				result+=temp[2];
			}
		}
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<parents.length;i++) {
			if(map[i/M][i%M]==1) {
				set.add(find(i));
			}
		}
		if(set.size()==1) {
			System.out.println(result);
		}else {
			System.out.println(-1);
		}
		
		
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
		return parents[a] =find(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
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
	static boolean isIn(int a, int b) {
		return a>=0 && b>=0 && a<N && b<M;
	}
}
