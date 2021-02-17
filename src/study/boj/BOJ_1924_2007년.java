package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.StringTokenizer;

public class BOJ_1924_2007년 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		Date date = new Date(107, M-1, D);
		String a = date.toString().substring(0, 3).toUpperCase();
		
		
		System.out.println(a);
	}
}
