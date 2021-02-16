package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1592_영식이와친구들 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] count = new int[N + 1];
		count[1] = 1;
		int nowBall = 1;
		int sum =0;
		
		while (true) {
			if (count[nowBall] % 2 == 1) {// 홀수번이면
				nowBall += L;
				if ((nowBall % N) != 0 && nowBall / N >= 1) {
					nowBall = nowBall % N;
				}
				
			} else {
				nowBall -= L;
				if (nowBall <= 0) {
					int temp = Math.abs(nowBall);
					temp %= N;
					nowBall = N - temp;
				}
				
			}
			count[nowBall]++;
			sum++;
			if(count[nowBall] == M) {
				break;
			}
			
		}
		System.out.println(sum);
		
	}
}
