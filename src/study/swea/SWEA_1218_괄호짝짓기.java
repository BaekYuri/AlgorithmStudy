package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Stack<Character> input;
	static Stack<Character> rightOne;
	static Stack<Character> leftOne;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			int result = 0;
			input = new Stack<>();
			rightOne = new Stack<>();
			leftOne = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				input.add(s.charAt(i));
			}
			while (!input.isEmpty()) {
				if (input.peek() != '(' && input.peek() != '[' && input.peek() != '{' && input.peek() != '<') {
					char temp = input.pop();
					rightOne.push(temp);
				} else {
					char temp = input.pop();
					leftOne.push(temp);
				}
			}
			int[][] count = new int[4][2];
			if(rightOne.size()!=leftOne.size()) {
				result = 0;
			}else {
				while(!leftOne.isEmpty()) {
					char temp = leftOne.pop();
					switch(temp) {
					case '(':
						count[0][0]++;
						break;
					case '[':
						count[1][0]++;
						break;
					case '{':
						count[2][0]++;
						break;
					case '<':
						count[3][0]++;
						break;
					}
				}
				while(!rightOne.isEmpty()) {
					char temp = rightOne.pop();
					switch(temp) {
					case ')':
						count[0][1]++;
						break;
					case ']':
						count[1][1]++;
						break;
					case '}':
						count[2][1]++;
						break;
					case '>':
						count[3][1]++;
						break;
					}
				}
				for(int i=0;i<4;i++) {
//					System.out.println(count[i][0]+" "+ count[i][1]);
					if(count[i][0] == count[i][1]) {
						result = 1;
					}else {
						result = 0;
						break;
					}
				}
				
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
			
		}
		System.out.println(sb);
	}
}
