package study.boj;
import java.util.Scanner;

public class BOJ_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		int gram5 = N/5;
		int gram3 = (N - 5*gram5)/3;
		int result = -1;
		while((gram5 * 5 + gram3 * 3) !=N) {
			if(gram5 <0) {
				break;
			}
			gram5--;
			gram3 = (N - 5*gram5)/3;

			
		}
		if(gram5<0) {
			result = -1;
		}else {
			result = gram5+gram3;
		}
		System.out.println(result);
	}
}
