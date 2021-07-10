package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1669_멍멍이쓰다듬기 {
	static long N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st  = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		long diference = M-N;
		if(diference==0) {
			System.out.println(0);
			return;
		}else if(diference==1) {
			System.out.println(1);
			return;
		}else if(diference==2) {
			System.out.println(2);
			return;
		}
		diference -=2;
		M-=2;
		int result = 2;
		long sum = 0;
		int temp = 2;
		int i= 0;
		while(true) {
			sum+=temp;
			
			if(diference<=sum) {
				result+=(i+1);
				break;
			}
			if(i%2==1) {
				temp++;
			}
			i++;
		}
		System.out.println(result);
	}
}
