package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS_210316 {
	static int N, M, V;
	static ArrayList<Integer>[] link;
	static boolean[] visited;
	static StringBuilder sb;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		link = new ArrayList[N+1];
		for(int t=1;t<=N;t++) {
			link[t] = new ArrayList<>();
		}
		for(int t=0;t<M;t++) {
			st = new StringTokenizer(br.readLine());
			int from  = Integer.parseInt(st.nextToken());
			int to  = Integer.parseInt(st.nextToken());
			link[from].add(to);
			link[to].add(from);
		}
		for(int t=1;t<=N;t++) {
			Collections.sort(link[t]);
		}
		visited = new boolean[N+1];
		sb = new StringBuilder();
		dfs(V);
		sb.append("\n");
		visited = new boolean[N+1];
		
		bfs();
		
		System.out.println(sb);
	}
	static void dfs(int start) {
		visited[start]=true;
		sb.append(start).append(" ");
		for(int t=0;t<link[start].size();t++) {
			int temp = link[start].get(t);
			if(!visited[temp]) {
				dfs(temp);
			}
		}
	}
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		
		while(!queue.isEmpty()) {
			int start = queue.poll();
			if(visited[start]) continue;
			visited[start] = true;
			sb.append(start).append(" ");
			for(int i=0;i<link[start].size();i++) {
				int temp = link[start].get(i);
				if(!visited[temp]) {
					queue.add(temp);
				}
			}
		}
	}
}
