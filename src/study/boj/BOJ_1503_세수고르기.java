package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1503_세수고르기 {
	static int N, M;

	static boolean[] notS;
	static int[] nowOne;
	static int minValue = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		
		notS = new boolean[1002];
		st = new StringTokenizer(br.readLine());

		for(int a=0;a<M;a++) {
			notS[Integer.parseInt(st.nextToken())] = true;
		}
		nowOne = new int[1000-M+1];
		for(int i=1,a=0;i<=1001;i++) {
			if(!notS[i]) {
				nowOne[a++] = i;
			}
		}
		combination(3, new int[3],0,1);
		
		System.out.println(minValue);
	}
	static void combination(int toChoose, int[] choosed, int start,int now) {
		if(now>N &&  Math.abs(N-now)>minValue) {
			return;
		}
		
		if(toChoose ==0) {
			int temp = Math.abs(N-now);
			
			minValue = Integer.min(minValue, temp);
			return;
		}
		for(int i=start;i<nowOne.length;i++) {
			choosed[choosed.length-toChoose] = nowOne[i];
			combination(toChoose-1, choosed, i, now*nowOne[i]);
		}
	}
}
