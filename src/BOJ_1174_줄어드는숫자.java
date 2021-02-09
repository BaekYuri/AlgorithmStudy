
import java.util.Scanner;

public class BOJ_1174_줄어드는숫자 {
	static int N;
	static int count=1;
	static int result=0, jari=1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.close();
		
	}

	static void powerset(int t,int[] c) {
		if(t == jari) {
			result = 0;
			for(int i=0;i<c.length;i++) {
				result += c[i]*(int) Math.pow(10, jari-i);
			}
			return;
		}
		if(t==0) {
			for(int i=1;i<10;i++) {
				c[jari-t] = i;
				powerset(t+1, c);
			}
		}
	}
}
