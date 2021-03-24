package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_1251_하나로 {
	static int N;
	static long[][] island;
	static int[] parents, rank;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			island = new long[N][2];
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				island[i][0] = Integer.parseInt(st.nextToken());
			}
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				island[i][1] = Integer.parseInt(st.nextToken());
			}
			PriorityQueue<long[]> queue = new PriorityQueue<>(new Comparator<long[]>() {

				@Override
				public int compare(long[] o1, long[] o2) {
					// TODO Auto-generated method stub
					return Long.compare(o1[2], o2[2]);
				}
			});
			
			for(int start=0;start<N;start++) {
				for(int end=start+1;end<N;end++) {
					long distance = Math.abs(island[start][0]-island[end][0])*Math.abs(island[start][0]-island[end][0])+ Math.abs(island[start][1]-island[end][1])*Math.abs(island[start][1]-island[end][1]);
					queue.add(new long[] {start,end,distance});
				}
			}
			double rate = Double.parseDouble(br.readLine());
			make();
			double result =0;
			while(!queue.isEmpty()) {
				long temp[] = queue.poll();
				if(union((int)temp[0],(int)temp[1])) {
					result+=temp[2];
				}
				Set<Integer> set= new HashSet<>();
				for(int i=0;i<N;i++) {
					set.add(find(i));
				}
				if(set.size()==1) break;
			}
			result*=rate;
			
			sb.append("#").append(t).append(" ").append(String.format("%.0f", result)).append("\n");
		}
		System.out.println(sb);
	}
	
	static void make() {
		parents = new int[N];
		rank = new int[N];
		for(int i=0;i<N;i++) {
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
	static boolean union(int temp, int temp2) {
		int aRoot = find(temp);
		int bRoot = find(temp2);
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
