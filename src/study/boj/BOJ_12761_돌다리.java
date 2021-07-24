package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12761_돌다리 {
	static int A,B,N,M;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[100001];
		visited[N] = true;
		queue.add(N);
		int depth = 0;
		outer: while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int now = queue.poll();
				if(now==M) {
					break outer;
				}
				for(int i=0;i<8;i++) {
					int nr = calculate(i,now);
					if(nr>=0 && nr<=100000 && !visited[nr]) {
						queue.add(nr);
						visited[nr] = true;
					}
				}
			}
			depth++;
		}
		
		System.out.println(depth);
	}
	static int calculate(int i, int now) {
		int nr=0;
		switch(i) {
		case 0:
			nr = now+1;
			break;
		case 1:
			nr = now-1;
			break;
		case 2:
			nr = now+A;
			break;
		case 3:
			nr = now-A;
			break;
		case 4:
			nr = now+B;
			break;
		case 5:
			nr = now-B;
			break;
		case 6:
			nr = now*A;
			break;
		case 7:
			nr = now*B;
			break;
		}
		
		return nr;
	}
}
