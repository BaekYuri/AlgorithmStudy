package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17406_배열돌리기4 {
	static int[][] array;
	static int N, M, K;
	static List<int[]> kList = new ArrayList<>();
	static int minimum = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		array = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			kList.add(new int[] {r,c,s});
		}
		permutation(new boolean[K], K, new int[K]);

		System.out.println(minimum);
	}

	private static void turn(int r, int c, int s, int[][] copied) {
		// 끝
		
		for (int i = 0; i < s; i++) {
			int startR = r - 1 - s + i;
			int startC = c - 1 - s + i;
			int temp = copied[startR][c - 1 + s - i];

			for (int a = c - 1 + s - i; a > startC; a--) {
				copied[startR][a] = copied[startR][a - 1];
			}
			for(int b = startR+1; b<=r-1+s-i;b++) {
				copied[b-1][startC] = copied[b][startC];
			}
			for(int a= startC+1;a<=c-1+s-i;a++) {
				copied[r-1+s-i][a-1] = copied[r-1+s-i][a];
			}
			for(int b=r-1+s-i;b>=startR+1;b--) {
				copied[b][c-1+s-i] = copied[b-1][c-1+s-i];
			}
			copied[startR+1][c-1+s-i] = temp;

		}

	}
	
	static void permutation(boolean[] visited, int toChoose, int[] choosed) {
		if(toChoose ==0) {
			int[][] copied = new int[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					copied[i][j] = array[i][j];
				}
			}
			
			for(int i=0;i<choosed.length;i++) {

				int[] temp = kList.get(choosed[i]);
				turn(temp[0],temp[1],temp[2],copied);
				
//				for (int[] row : copied) {
//					for (int v : row) {
//						System.out.print(v+" ");
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
			for(int i=0;i<N;i++) {
				int sum = 0;
				for(int j=0;j<M;j++) {
					sum+=copied[i][j];
				}
				minimum = Integer.min(minimum, sum);
			}
			
			return;
		}
		for(int a=0;a<K;a++) {
			if(visited[a]) continue;
			visited[a] = true;
			choosed[choosed.length-toChoose] = a;
			permutation(visited, toChoose-1,choosed);
			visited[a] = false;
		}
	}
	
}
