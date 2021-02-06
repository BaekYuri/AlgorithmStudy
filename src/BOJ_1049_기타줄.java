

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1049_기타줄 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] set = new int[M];
		int[] each = new int[M];
		for (int t = 0; t < M; t++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			set[t]=Integer.parseInt(st.nextToken());
			each[t]=Integer.parseInt(st.nextToken());
		}
		int result =0;
		Arrays.sort(set);
		Arrays.sort(each);
		if(each[0]*6 <=set[0]) {
			result = each[0]*N;
		}else {
			if(each[0]*(N%6) <= set[0]) {
				result = set[0]*(N/6) + each[0]*(N%6);
			}else {
				result = set[0]*((N/6)+1);
			}
		}
		
		System.out.println(result);
		
		
	}
}
