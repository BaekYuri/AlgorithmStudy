package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654_랜선자르기 {
	static int N, K;
	static long[] length;
	static long max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		length = new long[N];
		
		for(int i=0;i<N;i++) {
			length[i] = Integer.parseInt(br.readLine());
			
			max = Long.max(max, length[i]);
		}

		
		System.out.println(binarySearch(1,max));
	}
	static long binarySearch(long start, long end) {
		long count=0;
		long mid=0;
		while(start<=end) {
			count =0;
			mid = (start+end)/2;
			
			for(int i=0;i<N;i++) {
				count += length[i]/mid;
			}
			

			if(count<K) {
				end = mid-1;
			}else {
				start = mid+1;
			}

		}
		return end;
	}
}
