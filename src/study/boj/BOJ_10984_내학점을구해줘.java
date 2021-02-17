package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10984_내학점을구해줘 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			int csum = 0;
			double gsum =0;
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int C = Integer.parseInt(st.nextToken());
				double G = Double.parseDouble(st.nextToken());
				csum+=C;
				gsum+=G*C;
			}
			
			double result = gsum/csum;
			sb.append(String.format("%d %.1f\n", csum, result));
			
		}
		System.out.println(sb);
	}
}
