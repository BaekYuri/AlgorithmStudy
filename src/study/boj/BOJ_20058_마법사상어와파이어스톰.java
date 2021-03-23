package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20058_마법사상어와파이어스톰 {
	static int N, Q, length;
	static int[][] A;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		length = (int) Math.pow(2, Q);
		
		A = new int[length][length];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
	}
	public void fireStorm(int level) {
		int lvLength = (int)Math.pow(2, level);
		for(int i=0;i<A.length;i+=lvLength) {
			for(int j=0;j<A.length;j+=lvLength) {
				
				int[][] tempArr = new int[lvLength/2][lvLength/2];
				for(int a=i;a<i+(lvLength/2);i++) {
					for(int b=j;b<j+(lvLength/2);b++) {
						
					}
				}
				
			}
		}
	}
}
