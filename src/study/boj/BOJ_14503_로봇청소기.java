package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static int N, M;
	static int[][] map;
	static int[] robot;
	static boolean[][] clean;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		robot = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
		clean = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st=  new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(change(0)) {};
		
		int result= 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(clean[i][j] && map[i][j]==0) result++;
			}
		}
		System.out.println(result);
	}
	static boolean change(int cnt) {
		if(cnt>=4) {
			int nr = robot[0]+deltas[(robot[2]+2)%4][0];
			int nc = robot[1]+deltas[(robot[2]+2)%4][1];
			if(!isIn(nr,nc) || map[nr][nc]==1) {
				return false;
			}else if (isIn(nr,nc) && map[nr][nc]==0){
				robot[0] = nr;
				robot[1] = nc;
				return true;
			}
		}
		clean[robot[0]][robot[1]] = true;
		int nr = robot[0]+deltas[(robot[2]+3)%4][0];
		int nc = robot[1]+deltas[(robot[2]+3)%4][1];
		if(isIn(nr,nc) && !clean[nr][nc] && map[nr][nc]==0) {
			robot[0] = nr;
			robot[1] = nc;
			robot[2] = (robot[2]+3)%4;
			return true;
		}else {
			robot[2] = (robot[2]+3)%4;
			return change(cnt+1);
		}
		
	}
	static boolean isIn(int a, int b) {
		return a>=0 && b>=0&& a<N && b<M;
	}
}
