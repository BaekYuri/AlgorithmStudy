package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14620_꽃길 {
	static int N;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(N+1,new int[3],3);
		
		System.out.println(min);
	}
	static void combination(int start, int[] choosed, int toChoose) {
		if(toChoose ==0) {
			int get = getPrice(choosed);
			if(get!=-1) {
				min = Math.min(min, get);
			}
			return;
		}
		for(int i=start;i<N*(N-1);i++) {
			choosed[choosed.length- toChoose] = i;
			combination(i+1, choosed, toChoose-1);
		}
	}
	static int[][] deltas= {{1,0},{0,1},{0,-1},{-1,0},{0,0}};
	private static int getPrice(int[] choosed) {
		boolean[][] canMake = new boolean[N][N];
		boolean can = true;
		int result = 0;
		outer: for(int i=0;i<choosed.length;i++) {
		
			int r = choosed[i]/N;
			int c = choosed[i]%N;
			
			for(int d=0;d<5;d++) {
				int nr = r+deltas[d][0];
				int nc = c+deltas[d][1];
				if((isIn(nr,nc) &&canMake[nr][nc]) || !isIn(nr,nc)) {
					can = false;
					break outer;
				}
				canMake[nr][nc] = true;
				result+=map[nr][nc];
			}
		}
		if(can) {
			return result;
		}else {
			return -1;
		}
	}
	private static boolean isIn(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<N ;
	}
	
}
