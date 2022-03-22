package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_색종이만들기 {
	static int white, blue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] paper = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		white = 0;
		blue = 0;
		
		findPaper(N, paper);
		
		System.out.println(white);
		System.out.println(blue);
	}
	private static void findPaper(int n, int[][] paper) {
		if(n == 1) {
			if(paper[0][0]==1) blue++;
			else white++;
			return;
		}
		int[][] leftUp = new int[n/2][n/2];
		int tempWhite = 0;
		int tempBlue = 0;
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<n/2;j++) {
				if(paper[i][j]==1) {
					tempBlue++;
				}else {
					tempWhite++;
				}
				leftUp[i][j] = paper[i][j];
			}
		}
		
		int[][] leftDown = new int[n/2][n/2];
		for(int i=n/2;i<n;i++) {
			for(int j=0;j<n/2;j++) {
				if(paper[i][j]==1) {
					tempBlue++;
				}else {
					tempWhite++;
				}
				leftDown[i-(n/2)][j] = paper[i][j];
			}
		}
		
		int[][] rightUp = new int[n/2][n/2];
		
		for(int i=0;i<n/2;i++) {
			for(int j=n/2;j<n;j++) {
				if(paper[i][j]==1) {
					tempBlue++;
				}else {
					tempWhite++;
				}
				rightUp[i][j-(n/2)] = paper[i][j];
			}
		}
		
		int[][] rightDown = new int[n/2][n/2];
		
		for(int i=n/2;i<n;i++) {
			for(int j=n/2;j<n;j++) {
				if(paper[i][j]==1) {
					tempBlue++;
				}else {
					tempWhite++;
				}
				rightDown[i-(n/2)][j-(n/2)] = paper[i][j];
			}
		}
		
		if(tempBlue==0) {
			white++;
		}else if(tempWhite==0) {
			blue++;
		}else {
			findPaper(n/2, leftUp);
			findPaper(n/2, leftDown);
			findPaper(n/2, rightUp);
			findPaper(n/2, rightDown);
		}
		
	}
}
