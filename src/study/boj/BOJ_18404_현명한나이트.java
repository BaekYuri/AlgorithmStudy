package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18404_현명한나이트 {
	static int N, M;
	static int[] myKnight;
	static int[][] enemy;
	static int[][] deltas = {{-2,-1}, {-2,1}, {-1,-2}, {-1,2}, {1,-2}, {1,2}, {2,-1}, {2,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		myKnight = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
		
		int[][] map = getMin(myKnight);
		enemy = new int[M][];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]).append(" ");
		}
		
		System.out.println(sb);
		
	}
	
	static int[][] getMin(int[] me) {
		int result = 1;
		Queue<int[]> queue = new LinkedList<>();
		int[][] visited = new int[N+1][N+1];
		visited[me[0]][me[1]] = 987654321;
		queue.add(me.clone());
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int[] now = queue.poll();
				for(int d=0;d<8;d++) {
					int nr = now[0]+ deltas[d][0];
					int nc = now[1]+ deltas[d][1];
					
					if(nr>=1 && nr<=N && nc>=1 && nc<=N && visited[nr][nc]==0) {
						visited[nr][nc] = result;
						queue.add(new int[] {nr,nc});
					}
				}
			}
			result++;
		}
		
		return visited;
	}
}
