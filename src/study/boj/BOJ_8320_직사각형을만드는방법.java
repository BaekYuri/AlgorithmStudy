package study.boj;
import java.util.Scanner;

public class BOJ_8320_직사각형을만드는방법 {
	static int N;
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.close();
		// a*b<=N 인 경우의 조합을 찾아야한다
		// 1부터 N까지
		combination(2, new int[2],1);
		
		System.out.println(count);
	}

	static void combination(int toChoose, int[] choosed, int startIdx) {
		if(toChoose == 0) {
			if(choosed[0]*choosed[1]<=N) {
				count++;
			}
			return;
		}
		for (int i = startIdx; i <= N; i++) {
			choosed[choosed.length-toChoose] = i;
			combination(toChoose-1, choosed, i);
		}
	}
}
