package study.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정올_1681_해밀턴순환회로 {
	static int N;
	static int[][] matrix;
	static int min =Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int input = Integer.parseInt(st.nextToken());
				matrix[i][j] = input;
			}
		}
		permutation(N-1,new int[N-1],0, 0, new boolean[N]);
		if(min == Integer.MAX_VALUE) {
			System.out.println(0);
			return;
		}
		System.out.println(min);
		
	}
	static void permutation(int toChoose, int[] choosed,int length,int start, boolean[] visited) {
		if(length>=min) return;
		if(toChoose ==0) {
			if(matrix[choosed[choosed.length-1]][0]!=0) {
				length += matrix[choosed[choosed.length-1]][0]; 
				min = Integer.min(min, length);
			}
			return;
		}
		for(int i=1;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			choosed[choosed.length-toChoose] = i;
			if(matrix[start][i]!=0) {
				permutation(toChoose-1, choosed, length+matrix[start][i],i,visited);
			}
			visited[i] = false;
		}
	}
}
