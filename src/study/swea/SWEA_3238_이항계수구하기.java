package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//못풀었어요..

public class SWEA_3238_이항계수구하기 {
	static int MOD;
	static boolean[] sosu = new boolean[2000000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			long N = Long.parseLong(st.nextToken());
			long R = Long.parseLong(st.nextToken());
			MOD = Integer.parseInt(st.nextToken());
			long[] p = new long[MOD+1];
			p[0] = 1;
			for(int i=1;i<=MOD;i++) {
				p[i] = (p[i-1]*i)%MOD;
			}
			long x = N/MOD;
			long test = pow(p[MOD], x);
			long temp  = p[(int)(R%MOD)]*p[(int)((N-R)%MOD)];
			sb.append("#").append(t).append(" ").append((test*p[(int)(N%MOD)]*pow(temp%MOD,MOD-2))%MOD).append("\n");
		}
		System.out.println(sb);
	}
	static long pow(long a, long n) {
	    if (n == 0)
	        return 1;
	    long m = pow(a, n / 2);
	    long temp = (m * m) % MOD;
	    if (n % 2 == 0)
	        return temp;
	    else
	        return (a * temp)%MOD;
	}
}
