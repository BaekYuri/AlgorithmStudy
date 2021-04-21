package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17498_폴짝게임 {
	static int N, M, R;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer  st = new StringTokenizer(br.readLine());
		
		N  =Integer.parseInt(st.nextToken());
		M  =Integer.parseInt(st.nextToken());
		R  =Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		int[][] visited= new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
			if(i!=0)
				Arrays.fill(visited[i], Integer.MIN_VALUE);
		}
		
		for(int i=0;i<N-1;i++) {
			for(int j=0;j<M;j++) {
				
				
				for(int x=i+1, t=(x+R<=N)?x+R:N;x<t;x++) {
					for(int y=0, d = R-(x-i);y<=d;y++) {
						
	
						if(isIn(j+y) && visited[x][j+y]<visited[i][j]+(arr[i][j]*arr[x][j+y])) {
							visited[x][j+y] = visited[i][j]+(arr[i][j]*arr[x][j+y]);
						}
						if(isIn(j-y) && visited[x][j-y]<visited[i][j]+(arr[i][j]*arr[x][j-y])) {
							visited[x][j-y] = visited[i][j]+(arr[i][j]*arr[x][j-y]);
						}
					}
					
				}
				
				
			}
		}
		
		
		
		int result = Integer.MIN_VALUE;
		for(int i=0;i<M;i++) {
			result = Math.max(result, visited[N-1][i]);
		}
		
		System.out.println(result);
	}
	static boolean isIn(int x) {
		return x>=0 && x<M;
	}
}
