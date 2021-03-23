package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
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
		dijkstra();
	}
	static void dijkstra() {
		int[] result = new int[V+1];
		Arrays.fill(result, 987654321);
		result[first] = 0;
		boolean[] visited = new boolean[V+1];
		for(int i=1;i<=V;i++) {
			int minIdx = 0;
			int min = 987654321;
			for(int j=1;j<=V;j++) {
				if(!visited[j] && min>result[j]) {
					minIdx = j;
					min = result[j];
				}
			}
			visited[minIdx] = true;
			for(int j=0;j<link[minIdx].size();j++) {
				int[] temp = link[minIdx].get(j);
				if(!visited[temp[0]] &&
						result[minIdx]+temp[1]<result[temp[0]]) {
					result[temp[0]] = result[minIdx]+temp[1];
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
