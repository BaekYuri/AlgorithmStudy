package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6026_성수의비밀번호공격 {
	static int T;
	static int M,N;
	static int MOD = 1_000_000_007;
	static long[] p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		p = new long[101];
		p[0] = 1;
		for(int i=1;i<=100;i++) {
			p[i] = (p[i-1]*i)%MOD;
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			
			
//			long result = solve();
			sb.append("#").append(t).append(" ").append(solve()).append("\n");
		}
		System.out.println(sb);
	}
	//함수의 개수 ∑(-1)^i*kCi*(k-i)^n
	private static long solve() {
		long total = 0;;
		for(int i=0;i<=M;i++) {
			long l1 = (i%2==0)?1:-1;
			long l2 = nCr(i);
			long l3 = pow((M-i),N);
			long result = ((l1*l2)%MOD*l3)%MOD;
			total = (total+result + MOD) % MOD;
		}
		return total;
	}
	private static long nCr(int r) {
		if(r==0)
			return 1;
		
		long l1 = p[M];
		long l2 = pow(p[M-r],MOD-2);
		long l3 = pow(p[r],MOD-2);
		
		return ((l1*l2)%MOD*l3)%MOD;
	}
	
	static long pow(long a, int n) {
	    if (n == 0)
	        return 1;
	    long m = pow(a, n / 2);
//	    long temp = (m * m) % MOD;
	    if (n % 2 == 0)
	        return (m*m)%MOD;
	    else
	        return ((m*m)%MOD*a)%MOD;
	}
}
