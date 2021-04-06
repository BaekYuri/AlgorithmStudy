package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {
	static int N, M;
	static int[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tree = new int[N];
		
		st = new StringTokenizer(br.readLine());

		for(int i=0;i<N;i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		long start = 0;
		long end= 1000000000;
		end -=1;
		while(start<end) {
			long mid = (start+end)/2;
			
			long nowTree = getTree(mid);
			if(nowTree > M) {
				if(getTree(mid+1)<M) {
					start = mid;
					break;
				}
				start = mid+1;
			}else{
				end = mid;
			}
		}
		
		System.out.println(start);
		
	}
	static long getTree(long mid) {
		long result = 0;
		for(int t : tree) {
			result+= t>mid?t-mid:0;
		}
		return result;
	}
}
