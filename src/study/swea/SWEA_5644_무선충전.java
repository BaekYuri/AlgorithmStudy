package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5644_무선충전 {//상 우 하 좌
	static int[][] deltas = {{0,0},{0,-1},{1,0},{0,1},{-1,0}};
	static int[] batt;
	static List<int[]> list[];
	static List<int[]> map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			map = new ArrayList[11][11];
			for(int i=0;i<=10;i++) {
				map[i] = new ArrayList[11];
				for(int j=0;j<=10;j++) {
					map[i][j] = new ArrayList<>();
				}
			}
			int[] A = {1,1};
			int[] B = {10,10};
			
			StringTokenizer st= new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int BC = Integer.parseInt(st.nextToken());
			list = new ArrayList[M+1];
			for(int i=0;i<=M;i++) {
				list[i] = new ArrayList<>();
			}
			list[0].add(A.clone());
			list[0].add(B.clone());
			st= new StringTokenizer(br.readLine());
			for(int i=1;i<=M;i++) {
				int direction = Integer.parseInt(st.nextToken());
				int nr = A[0]+deltas[direction][0];
				int nc = A[1]+deltas[direction][1];
				list[i].add(new int[] {nr,nc});
				A[0] = nr;
				A[1] = nc;
			}
			
			st= new StringTokenizer(br.readLine());
			for(int i=1;i<=M;i++) {
				int direction = Integer.parseInt(st.nextToken());
				int nr = B[0]+deltas[direction][0];
				int nc = B[1]+deltas[direction][1];
				list[i].add(new int[] {nr,nc});
				B[0] = nr;
				B[1] = nc;
			}
			batt = new int[BC];
			for(int i=0;i<BC;i++) {
				st= new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c= Integer.parseInt(st.nextToken());
				int dis = Integer.parseInt(st.nextToken());
				int charge = Integer.parseInt(st.nextToken());
				batt[i] = charge;
				int[] tmpArr = new int[] {i,batt[i]};
				
				for(int a=r-dis;a<=r+dis;a++) {
					for(int b=c-dis;b<=c+dis;b++) {
						if(isIn(a,b)) {
							int temp = Math.abs(r-a) + Math.abs(c-b);
							if(temp<=dis) {
								map[a][b].add(tmpArr);
							}
						}
					}
				}
			}
			for(int i=1;i<11;i++) {
				for(int j=1;j<11;j++) {
					Collections.sort(map[i][j], (o1,o2)->{
						return o2[1]-o1[1];
					});
				}
			}
			int sum = 0;
			for(int i=0;i<=M;i++) {
				sum +=getBattery(list[i].get(0),list[i].get(1));
			}
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
	static int getBattery(int[] A, int[] B) {
		
		int[][] resultA = new int[2][2];
		int[][] resultB = new int[2][2];
		resultA[0][0]=-1;
		resultB[0][0]=-1;
		if(!map[A[0]][A[1]].isEmpty()) {
			resultA[0] = map[A[0]][A[1]].get(0);
			if(map[A[0]][A[1]].size()>1) {
				resultA[1] = map[A[0]][A[1]].get(1);
			}
		}
		if(!map[B[0]][B[1]].isEmpty()) {
			resultB[0] = map[B[0]][B[1]].get(0);
			if(map[B[0]][B[1]].size()>1) {
				resultB[1] = map[B[0]][B[1]].get(1);
			}
		}
		int result = 0;
		if(resultA[0][0]==resultB[0][0]) {
			result = resultA[0][1] + Math.max(resultA[1][1], resultB[1][1]);
		}else {
			result = resultA[0][1]+resultB[0][1];
		}
		return result;
	}
	static boolean isIn(int a, int b) {
		return a>=1 && a<11 && b>=1 && b<11;
	}
}
