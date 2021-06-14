package study.boj;

import java.util.Scanner;

public class BOJ_걷다보니신천역삼 {
	static int N;
	
	static int result=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		find(0,0,1);
		
		System.out.println(result);
	}
	
	static void find(int idx, int now, int mul) {
		if(idx==N) {
			if(now%3==0) result++;
			return;
		}
		for(int i=0;i<3;i++) {
			if(idx==0 && i==0) continue;
			find(idx+1, now+(i*mul),mul*10);
		}
	}
}
