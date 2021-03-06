package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18199_단어암기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N =Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
		
		
		int alpabet = 67108863; // binary : 11111111111111111111111111
		
		int[] bit= new int[N];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int a=0;a<s.length();a++) {
				int temp = s.charAt(a)-'a';
				bit[i] = bit[i] | (1<<temp);
			}
		
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			int result =0;
			st= new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			char alpa = st.nextToken().charAt(0);
			if(temp == 1) {
				alpabet = alpabet ^(1<<alpa-'a');
			}else {
				alpabet = alpabet |(1<<alpa-'a');
			}
			for(int j=0;j<N;j++) {
				if((bit[j] & alpabet) == bit[j]) {
					result ++;
				}
				
				
			}
			sb.append(result).append("\n");
		}
		
		
		
		System.out.println(sb);
	}
}
