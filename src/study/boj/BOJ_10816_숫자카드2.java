package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816_숫자카드2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int t = Integer.parseInt(st.nextToken());
			
			int start = 0;
			int end = N-1;
			
			int result = 0;
			while(start<end) {
				int mid = (start+end)/2;
				if(arr[mid]>t) {
					end = mid-1;
				}else if(arr[mid]<t){
					start = mid+1;
				}else {
					int a=start, b=end+1;
					for(int r = mid-1; r>=start;r--) {
						if(arr[r]!=t) {
							a = r+1;
							break;
						}
					}
					for(int r = mid+1; r<=end;r++) {
						if(arr[r]!=t) {
							b = r;
							break;
						}
					}
					result = b-a;
					break;
				}
			}
			System.out.println(result);
		}
	}
}
