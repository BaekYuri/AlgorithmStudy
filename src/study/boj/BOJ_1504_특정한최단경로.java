package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_특정한최단경로 {
	static int N, E;
	static int[][] road;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		road =new int[N+1][N+1];
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int start= Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			if(road[start][end]==0) {
				road[start][end] = length;
			}else {
				road[start][end] = Math.min(length, road[start][end]);
			}
			if(road[end][start]==0) {
				road[end][start] = length;
			}else {
				road[end][start] = Math.min(length, road[end][start]);
			}
		}
		st= new StringTokenizer(br.readLine());
		
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		int[] togo = {1,v1,v2,N};
		int INF = 987654321;
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)-> {
			
			return Integer.compare(o1[1], o1[1]);
			
		});
		boolean visited[] = new boolean[N+1];
		int[][] dy = new int[4][N+1];
		
		for(int t=0;t<4;t++) {
			queue.clear();
			visited = new boolean[N+1];
			Arrays.fill(dy[t], INF);
			dy[t][togo[t]] = 0;
			queue.add(new int[] {togo[t],0});
			for(int i=1;i<=N;i++) {
				int[] temp = queue.poll();
				while(temp != null && visited[temp[0]]) {
					temp = queue.poll();
				}
				if(temp==null) break;
				visited[temp[0]] = true;
				for(int j=1;j<=N;j++) {
					if(i==j) continue;
					dy[t][j] = Math.min(dy[t][j], temp[1]+road[temp[0]][j]);
					queue.add(new int[] {j,dy[t][j]});
				}
			}
		}
		
		int[][] realRoad= new int[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				realRoad[i][j] = dy[togo[i]-1][togo[j]];
			}
		}
		
//		queue.clear();
//		visited = new boolean[4];
//		int[] result =new int[4];
//		Arrays.fill(result, INF);
//		result[0] = 0;
//		queue.add(new int[] {0,0});
//		for(int i=0;i<4;i++) {
//			int[] temp = queue.poll();
//			while(temp != null && visited[temp[0]]) {
//				temp = queue.poll();
//			}
//			if(temp==null) break;
//			for(int j=0;j<4;j++) {
//				if(i==j) continue;
//				dy[t][j] = Math.min(dy[t][j], temp[1]+road[temp[0]][j]);
//				queue.add(new int[] {j,dy[t][j]});
//			}
//		}
		
		for(int[] a: realRoad) {
		System.out.println(Arrays.toString(a));}
	}
}
