package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2785_체인 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] chain = new int[N];
		
		for(int i=0;i<N;i++) {
			chain[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(chain);
		
		int nowChain = N;
		int nowGori = 0;
		
		int result = 0;
		for(int i=0;i<N;i++) {
			nowChain--;
			nowGori+=chain[i];
			
			if(nowGori>=nowChain-1) {
				result = nowChain;
				if(nowGori==nowChain-1) {
					result--;
				}
				break;
			}
		}
		
		System.out.println(result);
		
	}
}
