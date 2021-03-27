package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17779_게리맨더링2 {
	static int N;
	static int[][] map, union;
	static int result=Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N  =Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				for(int d1=1;d1<=j-1;d1++) {
					for(int d2=1;d2<=N-j-1;d2++) {
						if(i+d1+d2>N) continue;
						getUnion(i,j,d1,d2);
					}
				}
				
			}
		}
		System.out.println(result);
	}
	static void getUnion(int x, int y, int d1, int d2) {
		union = new int[N+1][N+1];
		union[x][y] = 5;
		int left = y;
		int leftCnt = 0;
		int right = y;
		int rightCnt = 0;
		for(int r=x+1;r<=x+d1+d2;r++,leftCnt++,rightCnt++) {
			if(leftCnt<d1) {
				left--;
			}else {
				left++;
			}
			if(rightCnt<d2) {
				right++;
			}else {
				right--;
			}
			for(int c=left;c<=right;c++) {
				union[r][c] = 5;
			}
			
		}
		int[] count = new int[6];
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) {
				if(union[r][c]==5) {
					count[5]+=map[r][c];
					continue;
				}
				if(r<x+d1 && c<=y) {
					count[1]+=map[r][c];
					union[r][c]=1;
				}else if(r>= 1 && r<=x+d2 && c<=N&& c>y) {
					count[2]+=map[r][c];
					union[r][c]=2;
				}else if(r>=x+d1 && r<=N && c<y-d1+d2) {
					count[3]+=map[r][c];
					union[r][c]=3;
				}else if(r>=x+d2 && r<=N && c>=y-d1+d2 && c<=N) {
					count[4]+=map[r][c];
					union[r][c]=4;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=1;i<6;i++) {
			max = Math.max(max, count[i]);
			min = Math.min(min, count[i]);
		}
		if(min==0) return;
		result= Integer.min(result, max-min);
	}
}
