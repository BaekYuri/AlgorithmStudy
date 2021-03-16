package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3078_좋은친구 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //우리반 학생 수
		int K = Integer.parseInt(st.nextToken()); //등수 차이
		
		int[] stuNameLength = new int[N];
		
		for(int t=0;t<N;t++) {
			String s = br.readLine();
			stuNameLength[t] = s.length();
		}
		int result = 0;
		for(int t=0;t<N-1;t++) {
			for(int r=t+1;r<t+K+1;r++) {
				if(r>=N) continue;
				if(stuNameLength[t] == stuNameLength[r]) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}
