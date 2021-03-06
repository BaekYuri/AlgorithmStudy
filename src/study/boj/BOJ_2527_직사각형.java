package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2527_직사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int a=0;a<4;a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char result =' ';
			int[][] square = new int[4][2];

			for(int i=0;i<4;i++) {
				square[i][0] = Integer.parseInt(st.nextToken());
				square[i][1] = Integer.parseInt(st.nextToken());
			}
			int min = Integer.min(square[0][0],square[1][0]);
			int max = Integer.max(square[0][0],square[1][0]);
			
			int min2 = Integer.min(square[2][0],square[3][0]);
			int max2 = Integer.max(square[2][0],square[3][0]);
			int point = 0;
			for(int i=min2 ; i<=max2;i++) {
				if(i>=min && i<=max) {
					point++;
					if(point == 2) {
						break;
					}
				}
			}
			
			int min3 = Integer.min(square[0][1],square[1][1]);
			int max3 = Integer.max(square[0][1],square[1][1]);
			
			int min4 = Integer.min(square[2][1],square[3][1]);
			int max4 = Integer.max(square[2][1],square[3][1]);
			int point2 = 0;
			
			for(int i=min4 ; i<=max4;i++) {
				if(i>=min3 && i<=max3) {
					point2++;
					if(point2 ==2) {
						break;
					}
				}
			}
			
			if(point == 0 || point2 == 0) {
				result = 'd';
			}else if(point == 1 && point2 ==1) {
				result = 'c';
			}else {
				if(point>1 && point2 >1) {
					result = 'a';
				}else {
					result ='b';
				}
			}
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
