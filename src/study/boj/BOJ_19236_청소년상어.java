package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19236_청소년상어 {
	static int[][] deltas = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
	static int[][][] fishMap;
	static Shark shark;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		fishMap = new int[4][4][2];
		
		for(int i=0;i<4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				fishMap[i][j][0] = Integer.parseInt(st.nextToken());
				fishMap[i][j][1] = Integer.parseInt(st.nextToken())-1;
			}
		}
		
		shark = new Shark(0, 0, fishMap[0][0][0], fishMap[0][0][1], getClone(fishMap));
		Queue<Shark> queue = new LinkedList<>();
		queue.add(shark);
		int result = Integer.MIN_VALUE;
		while(!queue.isEmpty()) {
			Shark now = queue.poll();
			now.map[now.x][now.y][0] = -1;
			moveFish(now.map, now.x, now.y);
			int depth = 1;
			int cnt =0;
			while(true) {
				int nr = now.x + deltas[now.direction][0]*depth;
				int nc = now.y + deltas[now.direction][1]*depth;
				if(!isIn(nr,nc)) break;
				if(now.map[nr][nc][0]!=-1) {
					int[][][] clone = getClone(now.map);
					queue.add(new Shark(nr, nc, now.point + clone[nr][nc][0], clone[nr][nc][1], clone));
					cnt++;
				}
				depth++;
			}
			if(cnt ==0) {
				result = Math.max(now.point, result);
			}
		}
		
		System.out.println(result);
		return;
	}
	static int[][][] getClone(int[][][] map){
		int clone[][][] = new int[4][4][2];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				for(int k=0;k<2;k++) {
					clone[i][j][k] = map[i][j][k];
				}
			}
		}
		return clone;
	}
	static void moveFish(int[][][] map,int x , int y) {
		
		for(int t=1;t<=16;t++) {
			int[] now = null;
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(map[i][j][0]==t) {
						now = new int[] {i,j};
					}
				}
			}
			if(now == null) continue;
			
			for(int d=0;d<8;d++) {
				int direction = (map[now[0]][now[1]][1]+d)%8;
				int nr= now[0]+ deltas[direction][0];
				int nc= now[1]+ deltas[direction][1];
				if(isIn(nr,nc) && !(x==nr && y == nc)) {
					map[now[0]][now[1]][1] = direction;
					int[] temp = map[now[0]][now[1]];
					map[now[0]][now[1]] = map[nr][nc];
					map[nr][nc] = temp;
					break;
				}
			}
		}
	}
	static boolean isIn(int a, int b) {
		return a>=0 && b>=0 && a<4 && b<4;
	}
	
	static class Shark{
		int x, y, point, direction;
		int[][][] map;
		
		public Shark(int x, int y, int point, int direction, int[][][] map) {
			super();
			this.x = x;
			this.y = y;
			this.point = point;
			this.direction = direction;
			this.map = map;
		}
	}
}
