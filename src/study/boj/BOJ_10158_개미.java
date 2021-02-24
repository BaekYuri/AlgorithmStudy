package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10158_개미 {
	static long N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long nowN = Long.parseLong(st.nextToken());
		long nowM = Long.parseLong(st.nextToken());
		long time = Long.parseLong(br.readLine());
		
		long timeN = (nowN+time)%(2*N);
		long timeM = (nowM+time)%(2*M);
		
		if(timeN>N) timeN = (2*N) - timeN;
		if(timeM>M) timeM = (2*M) - timeM;
		
		StringBuilder sb = new StringBuilder();
		sb.append(timeN).append(" ").append(timeM);
		System.out.println(sb);
	}

}
