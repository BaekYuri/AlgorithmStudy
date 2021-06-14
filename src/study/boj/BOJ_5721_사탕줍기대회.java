package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5721_사탕줍기대회 {
	static int N, M;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		StringBuilder sb = new StringBuilder();
		
		while(true){
			s = br.readLine();
			if(s.equals("0 0")) break;
			StringTokenizer st = new StringTokenizer(s);
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][M];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = 0;
			combination(0,arr,0);
			sb.append(max).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void combination(int idx, int[][] nowArr, int count) {
		if(idx == 8) {
			max = Math.max(max, count);
			return;
		}
		int maxVal = nowArr[0][0];
		int x = 0;
		int y = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(nowArr[i][j]==0) continue;
				if(maxVal<nowArr[i][j]) {
					maxVal = nowArr[i][j];
					x = i;
					y = j;
				}
				
			}
		}
		int[][] clone = getClone(nowArr);
		int add = change(x,y,clone);
		combination(idx+1,clone,count+add);
	}
	
	static int[][] getClone(int[][] arr){
		int[][] temp = new int[arr.length][arr[0].length];
		for(int i=0, il = arr.length;i<il;i++) {
			for(int j=0, jl=arr[0].length;j<jl;j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}
	
	static int change(int i, int j,int[][] arr) {
		int result = arr[i][j];
		arr[i][j] = 0;
		if(isIn(i-1,0)) {
			for(int y=0;y<M;y++) {
				arr[i-1][y] = 0;
			}
		}
		if(isIn(i+1,0)) {
			for(int y=0;y<M;y++) {
				arr[i+1][y] = 0;
			}
		}
		if(isIn(i,j-1)) {
			arr[i][j-1]=0;
		}
		if(isIn(i,j+1)) {
			arr[i][j+1]=0;
		}
		
		return result;
	}
	static boolean isIn(int a, int b) {
		return a>=0 && b>=0 && a<N && b<M;
	}
}
