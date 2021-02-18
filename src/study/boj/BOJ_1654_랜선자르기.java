package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654_랜선자르기 {
	static int N, K;
	static int[] length;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		length = new int[N];
		
		for(int i=0;i<N;i++) {
			length[i] = Integer.parseInt(br.readLine());
			min = Integer.min(min, length[i]);
			max = Integer.max(max, length[i]);
		}
		if(N>=K) {
			System.out.println(min);
			return;
		}
		
		System.out.println(binarySearch(1,min));
	}
	static int binarySearch(int start, int end) {
		int count=0;
		int mid=0;
		while(start<end) {
			count =0;
			mid = (start+end)/2;
			
			for(int i=0;i<N;i++) {
				count += length[i]/mid;
			}
			

			if(count<K) {
				end = mid-1;
			}else if(count>K){
				start = mid+1;
			}else {
				start = mid;
			}
			if(start+1==end) {
				return start;
			}
		}
		return end;
	}
}
