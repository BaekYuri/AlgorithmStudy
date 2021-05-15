package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3584_가장가까운공통조상 {
	static int N;
	static int[] parents;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			
			parents = new int[N+1];
			visited = new boolean[N+1];
			for(int i=0;i<N-1;i++) {
				st = new StringTokenizer(br.readLine());
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				parents[child] = parent;
			}
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			dfs(first);
			int result = dfs(second);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	static int dfs(int now) {
		visited[now] = true;
		if(parents[now]==0) {
			return now;
		}
		if(visited[parents[now]]) {
			return parents[now];
		}else {
			return dfs(parents[now]);
		}
		
	}
}
