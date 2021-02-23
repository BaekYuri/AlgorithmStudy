package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859_백만장자프로젝트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			long[] money = new long[N];
			
			long max = Integer.MIN_VALUE;
			for(int i=0; i<N;i++) {
				money[i] = Integer.parseInt(st.nextToken());

			}
			
			long used =0;
			long have=0;
			long result =0;
			for(int i=N-1;i>=0;i--) {
				if(max<money[i]) {
					result += have*max;
					max = Long.max(max, money[i]);
					have = 0;
				}else {
					have++;
					used +=money[i];
				}
			}
			result += have*max;
			result -= used;
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
