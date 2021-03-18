package study.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 정올_1863_종교 {
	static int N, M;
	static int parents[];
	static int rank[];
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		rank = new int[N+1];
		
		make();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			union(a,b);
		}
		HashSet<Integer> set = new HashSet<>();
		for(int i=1;i<=N;i++) {
			set.add(find(i));
		}
		System.out.println(set.size());
	}
	static void make() {
		for(int i=1;i<=N;i++) {
			parents[i] = i;
			
		}
	}
	static int find(int n) {
		if(parents[n] == n) {
			return n;
		}else {
			
			return parents[n] = find(parents[n]);
		}
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		if(rank[aRoot]<rank[bRoot]) {
			parents[aRoot] = bRoot;
		}else{
			parents[bRoot] = aRoot;
			if(rank[aRoot]==rank[bRoot]) rank[aRoot]++;
		}
		
		return true;
	}
}
