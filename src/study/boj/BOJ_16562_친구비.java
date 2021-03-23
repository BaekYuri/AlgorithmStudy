package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_16562_친구비 {
	static int N,M,K;
	static int money[];
	static int parents[];
	static int rank[];
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		money = new int[N+1];
		parents = new int[N+1];
		rank = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		make();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		int nowK = 0;
		
		HashSet<Integer> set = new HashSet<>();
		for(int i=1;i<N+1;i++) {
			set.add(find(i));
		}
		for(int i : set) {
			nowK += money[i];
		}
	
		if(nowK<=K) {
			System.out.println(nowK);
		}else {
			System.out.println("Oh no");
		}
	}
	static void make() {
		for(int i=0;i<N+1;i++) {
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
			if(money[aRoot]>money[bRoot]) {
				money[aRoot] = money[bRoot];
			}
		}else {
			parents[aRoot] = bRoot;
			if(money[aRoot]<money[bRoot]) {
				money[bRoot] = money[aRoot];
			}
			if(rank[aRoot]==rank[bRoot]) {
				rank[bRoot]++;
			}
		}
		return true;
	}
}
