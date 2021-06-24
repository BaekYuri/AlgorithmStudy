package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] depth = new int[W];
		int[][] liter = new int[W][2];
		
		for(int i=0;i<W;i++) {
			depth[i] = Integer.parseInt(st.nextToken());
			
			for(int a=0;a<i;a++) {
				liter[a][1] = Math.max(liter[a][1], depth[i]);
			}
			for(int b=i;b<W;b++) {
				liter[b][0] = Math.max(liter[b][0], depth[i]);
			}
		}
		int result = 0;
		for(int i=0;i<W;i++) {
			int temp = Math.min(liter[i][0], liter[i][1])-depth[i];
			temp = temp<0?0:temp;
			
			result+=temp;
		}
		
		System.out.println(result);
	}
}
