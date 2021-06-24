package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2866_문자열잘라내기 {
	static int N, M;
	static String[][] table;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		table = new String[N][M];
		
		int result = N-1;
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			table[i] = new String[M];
			for(int j=0;j<M;j++) {
				table[i][j] = Character.toString(s.charAt(j));
			}
		}
		String[] now = new String[M];
		for(int i=0;i<M;i++) {
			now[i] = new String();
		}
		for(int i=N-1;i>=0;i--) {
			HashSet<String> set = new HashSet<>();
			for(int j=0;j<M;j++) {
				now[j] = table[i][j]+now[j];
				set.add(now[j]);
			}
			if(set.size()!=M) {
				result--;
			}else {
				break;
			}
		}
		System.out.println(result<=0?0:result);
	}
}
