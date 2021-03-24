package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13905_세부_kruskal {
	static int N, M;
	static int start, end;
	static PriorityQueue<int[]> road;
	static int[] parents, rank;
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		
		
		road= new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o2[2], o1[2]);
			}
		});
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			road.add(new int[] {from,to,weight});
		}
		make();
		int result = 0;
		
		while(!road.isEmpty() && find(start)!=find(end) ) {
			int[] temp = road.poll();
			result = temp[2];
			union(temp[0],temp[1]);
		}
		if(find(start)!=find(end)) {
			System.out.println(0);
		}else {
			System.out.println(result);
		}
	}
	static void make() {
		parents = new int[N+1];
		rank = new int[N+1];
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
			
		}else {
			parents[aRoot] = bRoot;
			
			if(rank[aRoot]==rank[bRoot]) {
				rank[bRoot]++;
			}
		}
		return true;
	}
}
