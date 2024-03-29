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
			
			long[] p = new long[N+1];
			p[0] = 1;
			for(int i=1;i<=N;i++) {
				p[i] = (p[i-1]*i)%MOD;
			}
			
			sb.append("#").append(t).append(" ").append((p[N]*pow((p[R]*p[N-R])%MOD,MOD-2))%MOD).append("\n");
		}
		System.out.println(sb);
	}
	static long pow(long a, int n) {
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
