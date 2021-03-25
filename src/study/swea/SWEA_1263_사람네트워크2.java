package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1263_사람네트워크2 {
	static final int INF = 987654321;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[][] matrix = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
					if(i!=j && matrix[i][j]==0) {
						matrix[i][j]=INF;
					}
				}
			}
			
			for(int k=0;k<N;k++) {//거치는 정점
				
				for(int i=0;i<N;i++) {//시작 정점
					if(k==i) continue;
					for(int j=0;j<N;j++) {//끝 정점
						if(k==j || i==j) continue;
						matrix[i][j] = Integer.min(matrix[i][j], matrix[i][k]+matrix[k][j]);
					}
				}
				
			}

			int min = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				int sum = 0;
				for(int j=0;j<N;j++) {
					sum+=matrix[i][j];
				}
				min = Integer.min(sum, min);
			}
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
}
