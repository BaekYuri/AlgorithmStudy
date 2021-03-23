package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로_PQ {
	static int V,E, first;
	static List<int[]> link[];
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		first= Integer.parseInt(br.readLine());
		
		link = new ArrayList[V+1];
		for(int i=0;i<=V;i++) {
			link[i] = new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			link[start].add(new int[] {end,length});
		}
		int[] result = new int[V+1];
		Arrays.fill(result, 987654321);
		result[first] = 0;
		boolean[] visited = new boolean[V+1];
		PriorityQueue<int[]> queue =new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[1], o2[1]);
			}
		});
		queue.add(new int[] {first,0});
		while(!queue.isEmpty()) {
			int[] minArr = queue.poll();
			if(visited[minArr[0]]) continue;
			
			visited[minArr[0]] = true;
			for(int j=0;j<link[minArr[0]].size();j++) {
				int[] temp = link[minArr[0]].get(j);
				if(!visited[temp[0]] &&
						result[minArr[0]]+temp[1]<result[temp[0]]) {
					result[temp[0]] = result[minArr[0]]+temp[1];
					queue.add(new int[] {temp[0],result[temp[0]]});
				}
			}
		}
		
		StringBuilder sb= new StringBuilder();
		for(int i=1;i<=V;i++) {
			if(result[i]==987654321) {
				sb.append("INF");
			}else {
				sb.append(result[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
