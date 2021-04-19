package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5607_조합 {
	static int MOD = 1234567891;
	static boolean[] sosu = new boolean[2000000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			
			sb.append("#").append(t).append(" ").append(0).append("\n");
		}
		System.out.println(sb);
	}
	static void getSosu() {
		for(int i=2;i<sosu.length;i++) {
			if(sosu[i]) continue;
			int t= i+i;
			while(t<sosu.length) {
				sosu[t] = true;
				t+=i;
			}
		}
	}
}
