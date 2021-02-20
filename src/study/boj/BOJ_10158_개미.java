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
		long length = lcm(2*N,2*M);
		int nDeltas = 1;
		int mDeltas = 1;
		time %= length;
		int now =0;
		while(now<time) {
			long nn = nowN+nDeltas;
			long nm = nowM+mDeltas;
			now++;
			if(nn>N || nn<0) {
				nDeltas = -nDeltas;
				nn = nowN+nDeltas;
			}
			if(nm>M || nm<0) {
				mDeltas = -mDeltas;
				nm = nowM+mDeltas;
			}
			nowN = nn;
			nowM = nm;
			
		}

		StringBuilder sb = new StringBuilder();
		sb.append(nowN).append(" ").append(nowM);
		System.out.println(sb);
	}
	static long gcd(long a, long b){
		while(b!=0){
			long r = a%b;
			a= b;
			b= r;
		}
		return a;
	}

	static long lcm(long a, long b){
	    return a * b / gcd(a,b);
	}
}
