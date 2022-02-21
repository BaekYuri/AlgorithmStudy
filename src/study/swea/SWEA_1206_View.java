package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1206_View {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=10;t++) {
			int length = Integer.parseInt(br.readLine()); //가로 길이
			
			int[] buildings = new int[length]; //각 빌딩의 높이
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<length;i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}
			
			int result = getView(length, buildings);
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static int getView(int length, int[] buildings) {
		int view = 0;
		int left = 0;
		int right = 0;
		for(int i=2;i<length-2;i++) {
			left = Math.max(buildings[i-1], buildings[i-2]);
			right = Math.max(buildings[i+1], buildings[i+2]);
			
			int high = Math.max(left, right);
			
			if(high<buildings[i]) {
				view+=(buildings[i]-high);
			}
		}
		return view;
	}
}
