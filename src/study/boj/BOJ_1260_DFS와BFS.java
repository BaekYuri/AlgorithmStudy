package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		@SuppressWarnings("unchecked")
		List<Integer>[] connect = new ArrayList[N + 1];
		@SuppressWarnings("unchecked")
		List<Integer>[] connect2 = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			connect[i] = new ArrayList<>();
			connect2[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			connect[from].add(to);
			connect[to].add(from);
			
			connect2[from].add(to);
			connect2[to].add(from);
		}
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(connect[i]);
			Collections.sort(connect2[i], new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2-o1;
				}
			});
		}
		
		boolean[] visited = new boolean[N + 1];
		Stack<Integer> stack = new Stack<>();
		stack.add(V);
		while(!stack.isEmpty()) {
			int now = stack.pop();
			if (!visited[now]) {
				visited[now] = true;
				sb.append(now).append(" ");
				while(!connect2[now].isEmpty()) {
					stack.add(connect2[now].remove(0));
				}
			}
		}
		
		sb.append("\n");
		
		LinkedList<Integer> queue = new LinkedList<>();
		visited = new boolean[N + 1];
		queue.add(V);

		while (!queue.isEmpty()) {
			int now = queue.poll();
			if (!visited[now]) {
				visited[now] = true;
				sb.append(now).append(" ");
				while(!connect[now].isEmpty()) {
					queue.add(connect[now].remove(0));
				}
			}

		}
		
		
		System.out.println(sb);

	}
}
