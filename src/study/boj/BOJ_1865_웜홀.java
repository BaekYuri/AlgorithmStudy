package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865_웜홀 {
	static int N, M, W;

	static int[][] road;
	static boolean result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			road = new int[N + 1][N + 1];
			result = false;
			for(int i=0;i<N+1;i++) {
				Arrays.fill(road[i], Integer.MAX_VALUE);
				road[i][i]=0;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int ss = Integer.parseInt(st.nextToken());
				int ee = Integer.parseInt(st.nextToken());
				int tt = Integer.parseInt(st.nextToken());
				
				road[ss][ee] = Integer.min(tt, road[ss][ee]);
				road[ee][ss] = Integer.min(tt, road[ee][ss]);
				

			}
			
			
			
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int ss = Integer.parseInt(st.nextToken());
				int ee = Integer.parseInt(st.nextToken());
				int tt = Integer.parseInt(st.nextToken());
				
				road[ss][ee] = -tt;
			}
			
			for(int x=1;x<N+1;x++) {//거쳐서 갈 정점
				
				for(int y=1;y<N+1;y++) {//출발 정점
					if(y==x) continue;
					for(int z=1;z<N+1;z++) {//도착 정점
						if(road[y][x]==Integer.MAX_VALUE || road[x][z]==Integer.MAX_VALUE) continue;
						road[y][z] = Integer.min(road[y][z], road[y][x]+road[x][z]);
					}
				}
			}
			for(int x=1;x<N+1;x++) {
				if(road[x][x]<0) {
					result = true;
					break;
				}
			}
			
			if (result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}
