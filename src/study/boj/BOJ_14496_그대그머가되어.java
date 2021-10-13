package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14496_그대그머가되어 {
	static int a, b, N, M;
	static int[][] road;
	static int INF = 987654321;
	public static void main(String[] args) throws IOException {
		
		input();
		
		System.out.println(dijkstra());
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		road = new int[N+1][N+1];
		for(int i=0;i<N+1;i++) {
			Arrays.fill(road[i], INF);
			road[i][i] =0;
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			road[from][to] = 1;
			road[to][from] = 1;
		}
	}
	
	public static int dijkstra() {
		
		int[] distance = road[a].clone();
		
		PriorityQueue<int[]> queue = new PriorityQueue<>((int[] a, int[] b)->{
			
			return a[1]-b[1];
			
		}) ;
		for(int i=1;i<N+1;i++) {
			queue.add(new int[] {i,distance[i]});
		}
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(now[1]>=INF) continue;
			for(int i=1;i<N+1;i++) {
				if(i==now[0]) continue;
				if(now[1]+road[now[0]][i]<distance[i]) {
					distance[i] = now[1]+road[now[0]][i];
					queue.add(new int[] {i, distance[i]});
				}
			}
		}
		
		
		return distance[b]>=INF?-1:distance[b];
	}
}
