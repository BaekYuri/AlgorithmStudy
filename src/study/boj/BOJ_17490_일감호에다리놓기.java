package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17490_일감호에다리놓기 {
	static int N,M;
	static long K;
	static int[] parents , rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		K =Long.parseLong(st.nextToken());
		
		PriorityQueue<int[]> queue =new PriorityQueue<>((o1,o2)->{return Integer.compare(o1[1], o2[1]);});
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			queue.add(new int[] {i,Integer.parseInt(st.nextToken())});
		}
		boolean[] connect = new boolean[N+1];
		Arrays.fill(connect, true);
		for(int i=0;i<M;i++) {
			st= new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			int min = Math.min(first, second);
			int max = Math.max(first, second);
			
			if(min==1 && max==N) {
				connect[N] = false;
			}else {
				connect[min] = false;
			}
		}
		make();
		for(int i=1;i<=N;i++) {
			int toConnect = i+1;
			if(i==N) toConnect =1;
			if(connect[i]) {
				union(i,toConnect);
			}
		}
		boolean can= true;
		if(M>1) {
			while(!queue.isEmpty()) {
				int[] now = queue.poll();
				if(union(0,now[0])) {
					K-=now[1];
					if(K<0) {
						can = false;
						break;
					}
				}
			}
		}
		if(can) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
	
	static void make() {
		parents = new int[N+1];
		rank = new int[N+1];
		for(int i=0;i<=N;i++) {
			parents[i] = i;
		}
	}
	
	static int find(int n) {
		if(parents[n]==n) {
			return n;
		}
		return parents[n] = find(parents[n]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return false;
		}
		if(rank[aRoot]<rank[bRoot]) {
			parents[aRoot] = parents[bRoot];
		}else {
			parents[bRoot] = parents[aRoot];
			if(rank[aRoot]==rank[bRoot]) {
				rank[aRoot]++;
			}
		}
		return true;
	}
}
