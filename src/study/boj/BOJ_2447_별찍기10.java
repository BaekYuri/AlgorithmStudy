package study.boj;

import java.util.Scanner;

public class BOJ_2447_별찍기10 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] first = new int[][] {{1}};
		int[][] result = drawStar(N, first);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result.length;j++) {
				sb.append(result[i][j]==1?'*':' ');
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static int[][] drawStar(int n, int[][] now) {
		if(n==1) return now;
		int nowSize = now.length;
		int[][] newArr = new int[nowSize*3][nowSize*3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(i==1 && j==1) continue;
				for(int startX=nowSize*i;startX<nowSize*(i+1);startX++) {
					for(int startY=nowSize*j;startY<nowSize*(j+1);startY++) {
						newArr[startX][startY] = now[startX%nowSize][startY%nowSize];
					}
				}
				
			}
		}
		return drawStar(n/3, newArr);
	}
}
