package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2851_슈퍼마리오 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] mushroom = new int[10];
		int sum = 0;
		int standard = 100;
		int difference = Integer.MAX_VALUE;
		
		for (int i = 0; i < 10; i++) {
			mushroom[i] = Integer.parseInt(br.readLine());
			sum+=mushroom[i];
			if(difference>= Math.abs(standard-sum)) {
				difference = Math.abs(standard-sum);
			}else {
				sum-=mushroom[i];
				break;
			}
		}
		
		System.out.println(sum);
	}
}
