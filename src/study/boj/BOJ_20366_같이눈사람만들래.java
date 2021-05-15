package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20366_같이눈사람만들래 {
	static int[] snow;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		snow = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			snow[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(snow);
		
		int result = Integer.MAX_VALUE;
		for(int i=0; i<N-3;i++) {
			for(int j=i+3;j<N;j++) {

				int elsa = snow[i]+snow[j];
				
				int left= i+1;
				int right = j-1;
				while(left<right) {
					int anna = snow[left]+snow[right];
					
					int temp = elsa-anna;
					if(result>Math.abs(temp)) {
						result = Math.abs(temp);
					}
					
					if(temp<0) {
						right--;
					}else {
						left++;
					}
					
				}
			}
		}
		
		System.out.println(result);
	}
}
