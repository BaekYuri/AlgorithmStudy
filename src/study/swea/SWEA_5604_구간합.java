package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5604_구간합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			long result = 0;
			long x = 1;
			long start = A, end = B;
			while (start <= end) {

				long aSum = getSum(start) - start % 10;
				for (; start % 10 != 0 && start<=end; start++) {
					result += (aSum + start % 10) * x;
				}
				if(start>end) break;
				long bSum = getSum(end) - end % 10;
				for (; end % 10 != 9 && start<=end; end--) {
					if (end < 0) {
						end = -1;
						break;
					}
					result += (bSum + end % 10) * x;
				}
				result += (end - start + 1) / 10 * 45 * x;
				x *= 10;
				start /= 10;
				end /= 10;

				if (start == 0 && end == 0)
					break;
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	static long getSum(long a) {
		long tempSum = 0;
		while (a > 0) {
			tempSum += a % 10;
			a /= 10;
		}
		return tempSum;
	}

}
