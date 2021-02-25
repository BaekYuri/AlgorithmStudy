package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869_달팽이는올라가고싶다 {
	static long B, A, V;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		long max = V;
		long min = 0;
		
		long result = binarySearch(min,max);
		System.out.println(result);
	}

	static long binarySearch(long min, long max) {
		long mid=0;
		while (min < max) {
			mid = (min + max) / 2;
			long midResult = getHeight(mid);
			if(midResult > V) {
				max = mid-1;
			}else if(midResult <V){
				min = mid+1;
			}else {
				return mid;
			}
		}
		return max;
	}

	static long getHeight(long day) {
		if(day == 0) {
			return 0;
		}
		return (A - B) * (day) + B;
	}
}
