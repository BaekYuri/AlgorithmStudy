package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13905_세부 {
	static int N, M;
	static int start, end;
	static ArrayList<int[]> road[];
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		road = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			road[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			road[from].add(new int[] {to,weight});
			road[to].add(new int[] {from,weight});
		}
		
		
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o2[1], o1[1]);
			}
		});
		int[] result = new int[N+1];
		result[start]=INF;
		queue.add(new int[] {start,INF});
		boolean[] visited= new boolean[N+1];
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			if(visited[temp[0]]) continue;
			visited[temp[0]] = true;
			for(int i=0;i<road[temp[0]].size();i++) {
				int[] togo =road[temp[0]].get(i);
				int min = Integer.min(temp[1], togo[1]);
				result[togo[0]] = Integer.max(result[togo[0]], min);
				queue.add(new int[] {togo[0],result[togo[0]]});
			}
		}
		System.out.println(result[end]);
	}
}
