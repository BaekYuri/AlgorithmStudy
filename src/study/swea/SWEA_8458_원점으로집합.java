package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8458_원점으로집합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		long[] sums = new long[70000];
		for (int i = 0; i < sums.length; i++) {
			sums[i] = i * (i + 1) / 2;
		}
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			long[] nums = new long[N];
			long max = 0;
			boolean isEven = true;
			boolean isOdd = true;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				long a = Integer.parseInt(st.nextToken());
				long b = Integer.parseInt(st.nextToken());

				nums[i] = Math.abs(a) + Math.abs(b);
				max = Math.max(max, nums[i]);
				if(nums[i]%2==0) {
					isOdd = false;
				}else {
					isEven = false;
				}
			}
			int result = -1;
			if(!isOdd && !isEven) {
				sb.append("#").append(t).append(" ").append(result).append("\n");
				continue;
			}
			int temp = 0;
			for(int i=0;i<70000;i++) {
				temp+=i;
				if(temp>=max && temp%2 == max%2) {
					result = i;
					break;
				}
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
			
		}
		System.out.println(sb);
	}

}
