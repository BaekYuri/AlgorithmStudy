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
		int INF = 987654321;
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		road =new int[N+1][N+1];
		for(int i=0;i<=N;i++) {
			Arrays.fill(road[i], INF);
			road[i][i] = 0;
		}
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
		int[] togo = {1,v1,v2};
		
		PriorityQueue<long[]> queue = new PriorityQueue<>((o1,o2)-> {
			
			return Long.compare(o1[1], o2[1]);
			
		});
		boolean visited[] = new boolean[N+1];
		long[][] dy = new long[3][N+1];
		
		for(int t=0;t<3;t++) {
			queue.clear();
			visited = new boolean[N+1];
			Arrays.fill(dy[t], INF);
			dy[t][togo[t]] = 0;
			queue.add(new long[] {togo[t],0});
			while(!queue.isEmpty()) {
				long[] temp = queue.poll();
				if(visited[(int)temp[0]]) continue;
				visited[(int)temp[0]] = true;
				for(int j=1;j<=N;j++) {
					if(temp[0]==j) continue;
					if(!visited[j]) {
					dy[t][j] = Math.min(dy[t][j], temp[1]+road[(int)temp[0]][j]);
					queue.add(new long[] {j,dy[t][j]});
					}
				}
			}
			
		}
		
		long result = Long.min(dy[0][v1]+dy[1][v2]+dy[2][N], dy[0][v2]+dy[2][v1]+dy[1][N]);
		if(result>=INF) result = -1;
		System.out.println(result);
	}
}
