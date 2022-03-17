package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210_Ladder1_220221 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=10;t++) {
			
			int tc = Integer.parseInt(br.readLine());
			
			int[][] map = new int[100][100];
			int[] end = new int[2];
			for(int i=0;i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					
					if(map[i][j]==2) {
						end[0] = i;
						end[1] = j;
					}
				}
			}
			int start = findStart(map, end);
			
			sb.append("#").append(tc).append(" ").append(start).append("\n");
		}
		System.out.println(sb);
	}

	private static int findStart(int[][] map, int[] end) {
		int[][] deltas = {{0,1},{0,-1}}; //방향. 0:우 1:좌
		
		int[] nowState = new int[] {end[0],end[1]};
		
		while(nowState[0]>0) {
			boolean found = false;
			for(int i=0;i<2;i++) {
				int ti = nowState[0]+deltas[i][0];
				int tj = nowState[1]+deltas[i][1];
				
				if(isIn(ti,tj) && map[ti][tj]==1) {
					found = true;
					int x = ti;
					int y = tj;
					while(isIn(x,y) && map[x][y]==1) {
						nowState[0] = x;
						nowState[1] = y;
						x+=deltas[i][0];
						y+=deltas[i][1];
					}
				}
				if(found) {
					nowState[0]--;
					break;
				}
			}
			if(!found) {
				nowState[0]--;
			}
			
		}
		return nowState[1];
	}
	
	static boolean isIn(int i,int j) {
		return i>=0 && j>=0 && i<100 && j<100;
	}
}
