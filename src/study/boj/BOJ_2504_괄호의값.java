package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504_괄호의값 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		Stack<Character> left = new Stack<>();
		String result = new String();
		boolean found = true;
		outer: for(int i=0;i<s.length();i++) {
			char temp = s.charAt(i);
			switch(temp) {
			case '(':
				
				left.add(temp);
				break;
			case '[':
				
				left.add(temp);
				break;
			case ')':
				if(!left.isEmpty()) {
					if(left.peek()=='(') {
						left.pop();
						left.add('2');
					}
				}else {
					left.add(temp);
				}
				break;
			case ']':
				if(!left.isEmpty()) {
					int t= 0;
					while(!left.isEmpty() &&left.peek()!='[') {
						if(left.peek() =='(') {
							found = false;
							break outer;
						}else {
							t+=left.pop()-'0';
						}
					}
					
					if(left.peek()=='[') {
						left.pop();
						left.add('3');
					}else {
						
					}
				}else {
					left.add(temp);
				}
				break;
			}
		}
		
		System.out.println(left);
		
		
	}
}
