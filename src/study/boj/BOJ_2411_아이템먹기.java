package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2411_아이템먹기 {
	static int N, M, A, B;
	static int[][] map;
	static PriorityQueue<int[]> items;
	static int[][] deltas = {{1,0},{0,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		A =Integer.parseInt(st.nextToken());
		B =Integer.parseInt(st.nextToken());
		items = new PriorityQueue<>((o1,o2)-> {
			if(o1[0]==o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			}else {
				return Integer.compare(o1[0], o2[0]);
			}
			
		});
		map = new int[N][M]; //0: 빈칸 , 1:아이템, 2:장애물
		for(int i=0;i<A;i++) {
			st = new StringTokenizer(br.readLine());
			int nr = Integer.parseInt(st.nextToken())-1;
			int nc = Integer.parseInt(st.nextToken())-1;
			map[nr][nc]= 1;
			items.add(new int[] {nr,nc});
		}
		items.add(new int[] {N-1,M-1});
		for(int i=0;i<B;i++) {
			st = new StringTokenizer(br.readLine());
			int nr = Integer.parseInt(st.nextToken())-1;
			int nc = Integer.parseInt(st.nextToken())-1;
			map[nr][nc]= 2;
		}
		
		int[] start = {0,0};
		int[][] dp = new int[N][M];
		dp[0][0] = 1;
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<>();
		while(!items.isEmpty()) {
			int[] dest = items.poll();
			queue.clear();
			queue.add(start);
			while(!queue.isEmpty()) {
				int[] tmp = queue.poll();
				if(tmp[0] == dest[0] && tmp[1]== dest[1])
					break;
				if(visited[tmp[0]][tmp[1]]) continue;
				visited[tmp[0]][tmp[1]]= true;
				for(int d=0;d<2;d++) {
					int nr = tmp[0] + deltas[d][0];
					int nc = tmp[1] + deltas[d][1];
					if(nr<=dest[0] && nc<=dest[1] && map[nr][nc]!=2) {
						dp[nr][nc]+=dp[tmp[0]][tmp[1]];
						queue.add(new int[] {nr,nc});
					}
				}
			}
			start = dest;
		}
		System.out.println(dp[N-1][M-1]);
	}
}
