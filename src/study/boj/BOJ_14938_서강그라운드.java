package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14938_서강그라운드 {
	static int N,M,R;
	static int[][] road;
	static int value= Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		road = new int[N+1][N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			road[i][i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			road[from][to] = length;
			road[to][from] = length;
		}
		
		for(int i=1;i<=N;i++) {
			boolean[] temp = new boolean[N+1];

			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {i,0});
			int rst = 0;
			while(!q.isEmpty()) {
				int t[]= q.poll();
				if(temp[t[0]] || t[1]>M) continue;
				temp[t[0]] = true;
				rst+=road[t[0]][t[0]];
				for(int a=1;a<=N;a++) {
					if(road[t[0]][a]!=0) {
						q.add(new int[] {a,t[1]+road[t[0]][a]});
					}
				}
			}
			value = Integer.max(value, rst);
		}

		System.out.println(value);
	}

}
