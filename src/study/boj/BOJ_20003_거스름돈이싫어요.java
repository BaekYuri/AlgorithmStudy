package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20003_거스름돈이싫어요 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][] num = new long[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			num[i][0] = Long.parseLong(st.nextToken());
			num[i][1] = Long.parseLong(st.nextToken());
		}
		long bunja = num[0][0];
		long bunmo = num[0][1];
		long t = bunsuGcd(bunja,bunmo);
		bunja/=t;
		bunmo/=t;
		for(int i=1;i<N;i++) {
			t=bunsuGcd(num[i][0],num[i][1]);
			num[i][0]/=t;
			num[i][1]/=t;
			
			bunja = bunsuGcd(bunja, num[i][0]);
			
			bunmo = bunmo*num[i][1]/(bunsuGcd(bunmo,num[i][1]));
			
			
			long temp = bunsuGcd(bunmo, bunja);
			
			bunmo/=temp;
			bunja/=temp;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(bunja).append(" ").append(bunmo);
		System.out.println(sb);
	}
	
	static long gcd(long a, long b) {
		if(b==0) {
			return a;
		}
		return gcd(b,a%b);
	}
	static long bunsuGcd(long a, long b) {
		long mojaUp = Math.max(a, b);
		long mojaDown = Math.min(a, b);
		
		long temp = gcd(mojaUp, mojaDown);
		
		return temp;
	}
}
