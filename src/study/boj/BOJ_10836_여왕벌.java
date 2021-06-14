package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10836_여왕벌 {
	static int N, D;
	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		
		int[][] grow = new int[N][N];
		for(int d=0;d<D;d++) {
			st = new StringTokenizer(br.readLine());

			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			for(int i=0,x=N-1,y=0;i<2*N-1;i++) {
				if(zero>0) {
					zero--;
				}else if(one>0) {
					grow[x][y]+=1;
					one--;
				}else if(two>0) {
					grow[x][y]+=2;
					two--;
				}
				if(x>0) {
					x--;
				}else {
					y++;
				}
			}
			
		}
		
		for(int j=1;j<N;j++) {
			for(int i=1;i<N;i++) {
				grow[i][j]+=grow[0][j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(grow[i][j]+1).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
