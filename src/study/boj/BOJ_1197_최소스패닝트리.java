package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리 {
	static int V, E;
	static PriorityQueue<int[]> queue;
	static int[] parents,rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[2], o2[2]);
			}
		});
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			queue.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		make();
		long result = 0;
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			if(union(temp[0],temp[1])) {
				result += temp[2];
			}
		}
		System.out.println(result);
	}
	static void make() {
		parents= new int[V+1];
		rank= new int[V+1];
		for(int i=0;i<V+1;i++) {
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
		if(rank[aRoot]<rank[bRoot]) {
			parents[aRoot] = bRoot;
		}else {
			parents[bRoot] = aRoot;
			if(rank[aRoot]==rank[bRoot]) {
				rank[aRoot]++;
			}
		}
		return true;
	}
}
