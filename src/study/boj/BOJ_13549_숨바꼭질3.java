package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int max = Integer.max(N, K);
		if(N==0 && K ==0) {
			System.out.println(0);
			return;
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {N,0,0});//현위치, 순간이동, 깊이
		boolean[] visited= new boolean[2*max];
		int[] minDistance = new int[2*max];
		Arrays.fill(minDistance, 987654321);
		int result =987654321;
		while(!queue.isEmpty()) {
			
				int[] now = queue.poll();
				if(now[2]>result) continue;
				if(now[0] == K) {
					result = Integer.min(now[2],result);
					
				}
				if(minDistance[now[0]]<=now[2]) continue;
				minDistance[now[0]]=now[2];
				
				int nr = now[0]*2;
				if(nr>=0 && nr<visited.length) {
					queue.add(new int[] {nr,now[1]+1,now[2]});
				}
				nr = now[0]+1;
				if(nr>=0 && nr<visited.length) {
					queue.add(new int[] {nr,now[1],now[2]+1});
				}
				nr = now[0]-1;
				if(nr>=0 && nr<visited.length) {
					queue.add(new int[] {nr,now[1],now[2]+1});
				}
				
			
		}
		System.out.println(result);
	}
}
