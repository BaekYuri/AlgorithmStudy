package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21317_징검다리건너기 {
	static int INF = 987654321;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[][] distance= new int[N][N];
		
		for(int i=0;i<N;i++) {
			Arrays.fill(distance[i], INF);
		}
		
		for(int i=0;i<N;i++) {
			distance[i][i] = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(i==N-1) {
				int k = Integer.parseInt(st.nextToken());
				for(int j=0;j<N-3;j++) {
					distance[j][j+3] = k;
				}
			}else {
				for(int j=1;j<=2;j++) {
					if(isIn(i+j)) {
						distance[i][i+j] = Integer.parseInt(st.nextToken());
					}
				}
			}
		}
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0});
		int[][] visited= new int[2][N+2];
		Arrays.fill(visited[0], INF);
		Arrays.fill(visited[1], INF);
		visited[0][0] = 0;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i=1;i<=3;i++) {
				int nr = now[0]+i;
				if(isIn(nr)) {
					if(i<=2) {
						if(visited[now[1]][nr]> visited[now[1]][now[0]]+distance[now[0]][nr]) {
							visited[now[1]][nr] = visited[now[1]][now[0]]+distance[now[0]][nr];
							queue.add(new int[] {nr,now[1]});
						}
					}else {
						if(now[1]==0 && visited[1][nr]>visited[now[1]][now[0]]+distance[now[0]][nr]) {
							visited[1][nr] = visited[now[1]][now[0]]+distance[now[0]][nr];
							queue.add(new int[] {nr,1});
						}
					}
					
				}
			}
			
		}
		
		System.out.println(Math.min(visited[1][N-1], visited[0][N-1]));

	}
	static boolean isIn(int a) {
		return a>=0 && a<N;
	}
}
