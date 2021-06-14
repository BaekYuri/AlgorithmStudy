package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17615_볼모으기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = Integer.MAX_VALUE;
		int N = Integer.parseInt(br.readLine());
		
		String ball = br.readLine();
		
		char last = ball.charAt(0);
		int sameCnt= 1;
		
		int redCnt = 0;
		int blueCnt = 0;
		
		if(last=='R') {
			redCnt++;
		}else {
			blueCnt++;
		}
		
		for(int i=1;i<N;i++) {
			char now = ball.charAt(i);
			if(now =='R') {
				redCnt++;
			}else {
				blueCnt++;
			}
			if(now == last) {
				sameCnt++;
			}else {
				sameCnt = 1;
			}
			last = now;
		}
		
		if(last=='R') {
			redCnt-=sameCnt;
		}else {
			blueCnt-=sameCnt;
		}
		
		
		result = Math.min(redCnt, blueCnt);
		
		
		last = ball.charAt(N-1);
		sameCnt= 1;
		
		redCnt = 0;
		blueCnt = 0;
		
		if(last=='R') {
			redCnt++;
		}else {
			blueCnt++;
		}
		
		for(int i=N-2;i>=0;i--) {
			char now = ball.charAt(i);
			if(now =='R') {
				redCnt++;
			}else {
				blueCnt++;
			}
			if(now == last) {
				sameCnt++;
			}else {
				sameCnt = 1;
			}
			last = now;
		}
		
		if(last=='R') {
			redCnt-=sameCnt;
		}else {
			blueCnt-=sameCnt;
		}
		
		int result2 = Math.min(redCnt, blueCnt);
		System.out.println(Math.min(result, result2));
	}
}
