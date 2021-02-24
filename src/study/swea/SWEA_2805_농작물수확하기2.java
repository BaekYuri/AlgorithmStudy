package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805_농작물수확하기2 {
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			
			int center = N/2;
			int result = 0;
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				for(int j=0;j<N;j++) {
					int distance = Math.abs(center-i) + Math.abs(center-j);
					if(distance<=center) {
						int temp = s.charAt(j) -'0';
						result+=temp;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
