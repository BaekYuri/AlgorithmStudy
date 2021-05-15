package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_10026_적록색약 {
	static int N;
	static char normalMap[][], weeknessMap[][];
	static int[] normalParents, weeknessParents, normalRank, weeknessRank;
	static int[][] deltas= {{1,0},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		normalMap = new char[N][N];
		weeknessMap = new char[N][N];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				normalMap[i][j] = s.charAt(j);
				weeknessMap[i][j]= normalMap[i][j]=='G'?'R':normalMap[i][j];
			}
		}
		make();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				for(int d=0;d<2;d++) {
					int nr = i+deltas[d][0];
					int nc = j+deltas[d][1];
					if(isIn(nr,nc)) {
						if(normalMap[i][j]==normalMap[nr][nc]) {
							union(i*N+j, nr*N+nc, normalParents, normalRank);
						}
						if(weeknessMap[i][j]==weeknessMap[nr][nc]) {
							union(i*N+j, nr*N+nc, weeknessParents, weeknessRank);
						}
					}
				}
			}
		}
		HashSet<Integer> normal = new HashSet<>();
		HashSet<Integer> weekness = new HashSet<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				normal.add(find(i*N+j, normalParents));
				weekness.add(find(i*N+j, weeknessParents));
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(normal.size()).append(" ").append(weekness.size());
		System.out.println(sb);
	}
	static void make() {
		normalParents = new int[N*N];
		weeknessParents = new int[N*N];
		normalRank = new int[N*N];
		weeknessRank = new int[N*N];
		for(int i=0;i<N*N;i++) {
			normalParents[i] = i;
			weeknessParents[i] = i;
		}
	}
	static int find(int a, int[] who) {
		if(who[a]==a) {
			return a;
		}
		return who[a] = find(who[a], who);
		
	}
	
	static boolean union(int a, int b, int[] who, int[] whoRank) {
		int aRoot = find(a, who);
		int bRoot = find(b, who);
		if(aRoot == bRoot) {
			return false;
		}
		if(whoRank[aRoot]>whoRank[bRoot]) {
			who[bRoot] = aRoot;
		}else {
			who[aRoot] = bRoot;
			if(whoRank[aRoot]==whoRank[bRoot]) {
				whoRank[bRoot]++;
			}
		}
		return true;
	}
	static boolean isIn(int a, int b) {
		return a<N && b<N;
	}
}
