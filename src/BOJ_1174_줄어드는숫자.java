
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_1174_줄어드는숫자 {
	static int N;
	static int count = 1;
	static long result = 0;
	static List<Long> numList = new ArrayList<>();
	static char[] numbers = { '9', '8', '7', '6', '5', '4', '3', '2', '1', '0' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.close();
		if (N > 1023) {
			System.out.println(-1);
			return;
		}
		powerset(new boolean[10], 10);
		Collections.sort(numList);
		System.out.println(numList.get(N-1));
	}

	static void powerset(boolean[] choosed, int toChoose) {
		if (toChoose == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < choosed.length; i++) {
				if (choosed[i]) {
					sb.append(numbers[i]);
				}
			}
			if (!sb.toString().equals("")) {
				numList.add(Long.parseLong(sb.toString()));
			}
			return;
		}
		choosed[choosed.length - toChoose] = true;
		powerset(choosed, toChoose - 1);
		choosed[choosed.length - toChoose] = false;
		powerset(choosed, toChoose - 1);
	}

}
