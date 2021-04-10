package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15558_점프게임 {
	static int N, k;
	static int[][] left;
	static int kanStart = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		left = new int[2][N];
		String s = br.readLine();
		for(int i=0;i<N;i++) {
			left[0][i] = s.charAt(i)-'0';
		}
		
		s = br.readLine();
		for(int i=0;i<N;i++) {
			left[1][i] = s.charAt(i)-'0';
		}
		
		Queue<int[]> queue = new LinkedList<>();
		boolean visited[][] = new boolean[2][N];
		visited[0][0] = true;
		queue.add(new int[] {0,0});
		int result = 0; 
		
		outer: while(!queue.isEmpty()) {
			int size= queue.size();
			while(size-->0) {
				int[] now = queue.poll();
				if(now[1]<kanStart) continue;
				int nr = now[0]==0?1:0;
				int nc = now[1]+1;
				if(nc >= N) {
					result = 1;
					break outer;
				}
				if(isIn(nc) && !visited[now[0]][nc] && left[now[0]][nc]==1) {
					visited[now[0]][nc] = true;
					queue.add(new int[] {now[0],nc});
				}
				nc = now[1]-1;
				if(nc >= N) {
					result = 1;
					break outer;
				}
				if(isIn(nc) && !visited[now[0]][nc] && left[now[0]][nc]==1) {
					visited[now[0]][nc] = true;
					queue.add(new int[] {now[0],nc});
				}
				nc = now[1]+k;
				if(nc >= N) {
					result = 1;
					break outer;
				}
				if(isIn(nc) && !visited[nr][nc] && left[nr][nc]==1) {
					visited[nr][nc] = true;
					queue.add(new int[] {nr,nc});
				}
				
			}
			kanStart++;
		}
		System.out.println(result);
	}
	static boolean isIn(int n) {
		return n>=kanStart && n<N;
	}
}
