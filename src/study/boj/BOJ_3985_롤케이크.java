package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3985_롤케이크 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean[] cake = new boolean[L+1];
		Arrays.fill(cake, true);
		
		int wantMax = Integer.MIN_VALUE;
		int realMax = Integer.MIN_VALUE;
		
		int wantResult=0, realResult=0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int wantLength = to-from+1;
			if(wantLength>wantMax) {
				wantMax = wantLength;
				wantResult = i+1;
			}
			int cakeLength =0;
			for(int t=from;t<=to;t++) {
				if(cake[t]) {
					cake[t] = false;
					cakeLength++;
				}
			}
			if(cakeLength>realMax) {
				realMax = cakeLength;
				realResult = i+1;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(wantResult).append("\n").append(realResult);
		
		System.out.println(sb);
	}
}
