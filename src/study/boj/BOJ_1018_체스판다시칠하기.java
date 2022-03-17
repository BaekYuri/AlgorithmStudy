package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[N][M];
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		System.out.println(find(board, N, M));
	}

	private static int find(char[][] board, int n, int m) {
		int result = 123456789;
		for(int i=0;i<=n-8;i++) {
			for(int j=0;j<=m-8;j++) {
				int Wstart = 0;
				int Bstart = 0;
				for(int a=i;a<i+8;a++) {
					for(int b=j;b<j+8;b++) {
						if(a%2==0) {
							if(b%2==0) {
								if(board[a][b]!='W') Wstart++;
								else Bstart++;
							}else {
								if(board[a][b]=='W') Wstart++;
								else Bstart++;
							}
						}else {
							if(b%2==0) {
								if(board[a][b]!='B') Wstart++;
								else Bstart++;
							}else {
								if(board[a][b]=='B') Wstart++;
								else Bstart++;
							}
						}
					}
				}
				
				result = Math.min(result, Wstart);
				result = Math.min(result, Bstart);
			}
		}
		return result;
	}
}
