package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4889_안정적인문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int tc=1;
		StringBuilder sb = new StringBuilder();
		while(s.charAt(0)!='-') {
			int result = 0;
			Stack<Character> left = new Stack<>();
			
			for(int i=0;i<s.length();i++) {
				char now = s.charAt(i);
				if(now=='}') {
					if(left.isEmpty()) {
						result++;
						left.push('{');
					}else {
						left.pop();
					}
				}else {
					left.push('{');
				}
			}
			result+= left.size()/2;
			
			sb.append(tc++).append(". ").append(result).append("\n");
			s = br.readLine();
		}
		System.out.println(sb);
	}
}
