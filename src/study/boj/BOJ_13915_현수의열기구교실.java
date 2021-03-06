package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_13915_현수의열기구교실 {
	static Set<String> result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		String r;
		while((r = br.readLine())!=null) {
			int N = Integer.parseInt(r);
			result = new HashSet<>();
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				calculate(s);
			}
			sb.append(result.size()).append("\n");
		}
		System.out.println(sb);
	}
	static void calculate(String s) {
		int[] num = new int[10];
		for(int i=0;i<s.length();i++) {
			num[s.charAt(i)-'0']++;
		}
		StringBuilder sb= new StringBuilder();
		for(int i=1;i<10;i++) {
			if(num[i]!=0) {
				sb.append(i);
			}
		}
		result.add(sb.toString());
	}
}
