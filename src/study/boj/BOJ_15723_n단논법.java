package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15723_n단논법 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> alpa[] = new ArrayList[26];
		for(int i=0;i<26;i++) {
			alpa[i] = new ArrayList<>();
		}
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = st.nextToken().charAt(0) -'a';
			st.nextToken();
			int to = st.nextToken().charAt(0) -'a';
			alpa[from].add(to);
		}
		StringBuilder sb= new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {	
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = st.nextToken().charAt(0) -'a';
			st.nextToken();
			int to = st.nextToken().charAt(0) -'a';
			boolean isTrue = false;
			Queue<Integer> queue = new LinkedList<>();
			queue.add(from);
			boolean[] visited = new boolean[26];
			while(!queue.isEmpty()) {
				int now = queue.poll();
				if(visited[now]) continue;
				visited[now] =true;
				if(alpa[now].contains((Object)to)){
					isTrue = true;
					break;
				}else {
					queue.addAll(alpa[now]);
				}
			}
			if(isTrue) {
				sb.append("T").append("\n");
			}else {
				sb.append("F").append("\n");
			}
		}
		System.out.println(sb);
	}
}
