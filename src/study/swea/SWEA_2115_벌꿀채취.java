package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115_벌꿀채취 {
	static int N, M, C;
	static int[][] honey;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T= Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			honey = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					honey[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] advantage = new int[N][N-M+1];
			for(int i=0;i<N;i++) {
				for(int j=0, size= advantage[0].length;j<size;j++) {
					int[] temp = new int[M];
					int sum = 0;
					for(int k=j;k<j+M;k++) {
						temp[k-j] = honey[i][k];
						sum+=honey[i][k];
						advantage[i][j]+= honey[i][k]*honey[i][k];
					}
					
					if(sum>C) {
						max = 0;
						powerset(temp, 0, new boolean[M], 0, 0);
						advantage[i][j] = max;
						//만약 C보다 크면 뭐 하나를 빼야함
					}
					
				}
			}
			
			
			max = 0;
			combination(advantage, -1, -1, 0, 0);
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
	static void powerset(int[] arr, int idx, boolean[] visited,int now, int nowC) {
		if(idx == arr.length) {
			if(nowC<=C && now>max) {
				max = now;
			}
			return;
		}
		visited[idx] = true;
		powerset(arr, idx+1, visited, now+arr[idx]*arr[idx], nowC+arr[idx]);
		visited[idx] = false;
		powerset(arr, idx+1, visited, now, nowC);
	}
	
	static void combination(int[][] ad, int x, int y, int m, int idx) {
		if(idx == 2) {
			max = Math.max(max, m);
			return;
		}
		for(int i=x==-1?0:x;i<ad.length;i++) {
			for(int j=i==x?y+M:0;j<ad[0].length;j++) {
				combination(ad, i,j, m+ad[i][j], idx+1);
			}
		}
	}
}
