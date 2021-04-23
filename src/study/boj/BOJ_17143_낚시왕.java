package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {
	static int R, C, M;
	static int[][] map;
	static Shark[] shark;
	static int[][] deltas= {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		shark = new Shark[M];
		for(int i=0;i<M;i++) {
			
			st = new StringTokenizer(br.readLine());
			shark[i] = new Shark(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
			map[shark[i].r][shark[i].c]= shark[i].z;
		}
		int result = 0;
		for(int i=0;i<C;i++) {
			int r = Integer.MAX_VALUE;
			int min= Integer.MAX_VALUE;
			for(int j=0;j<M;j++) {
				if(!shark[j].alive || shark[j].c!=i) continue;
				
				if(r>shark[j].r) {
					min = j;
					r = shark[j].r;
				}
			}
			if(min != Integer.MAX_VALUE) {
				map[shark[min].r][shark[min].c]= 0;
				shark[min].alive = false;
				result+= shark[min].z;
			}
			moveShark();
			
		}
		System.out.println(result);
	}
	static void moveShark() {
		int[][] tempMap = new int[R][C];
		for(int i=0;i<M;i++) {
			if(!shark[i].alive) continue;
			int d = shark[i].d;
			int RorC = d==0 || d==1?R:C;
			int temp = d==0 || d==1?shark[i].r:shark[i].c;
			int togo = d==0 || d==1?shark[i].s:shark[i].s;
			
			int result = temp+deltas[shark[i].d][0]*togo + deltas[shark[i].d][1]*togo;
			if(result < 0) {
				switch(shark[i].d) {
				case 0:
					shark[i].d= 1;
					break;
				case 3:
					shark[i].d = 2;
					break;
				}
			}
			result = Math.abs(result);
			result = d==0|| d==1?result%(R*2-2):result%(C*2-2);
			if(result<RorC) {
				//그냥 그대로
			}else {
				result = RorC-1-(result-RorC+1);
				switch(shark[i].d) {
				case 0:
					shark[i].d= 1;
					break;
				case 1:
					shark[i].d = 0;
					break;
				case 2:
					shark[i].d = 3;
					break;
				case 3:
					shark[i].d = 2;
					break;
				}
			}
			int r=0, c=0;
			if(d==0 || d==1) {
				r = result;
				c= shark[i].c;
			}else {
				r = shark[i].r;
				c = result;
			}
			shark[i].r = r;
			shark[i].c = c;
			if(shark[i].z<tempMap[r][c]) {
				shark[i].alive = false;
			}else{
				if(tempMap[r][c]!=0) {
					for(int j=0;j<M;j++) {
						if(j!=i && shark[j].r == r && shark[j].c == c && shark[j].z == tempMap[r][c] && shark[j].alive) {
							shark[j].alive = false;
							 break;
						}
					}
				}
				
				tempMap[r][c] = shark[i].z;
			}
			
			
		}
		
		map = tempMap;
	}
	static class Shark{
		int r,c,s,d,z;
		boolean alive;
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.alive = true;
		}
		
		@Override
		public String toString() {
			
			return String.format("r:%d c:%d 속력:%d 방향:%d 크기:%d 생존:", r,c,s,d,z)+alive;
		}
	}
}
