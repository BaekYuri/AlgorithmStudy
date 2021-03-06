package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ_17413_단어뒤집기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> reverseStack = new Stack<>();
		Queue<Character> reverseQueue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int nowStatus = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '<') {
				while (!reverseStack.isEmpty()) {
					sb.append(reverseStack.pop());
				}
				nowStatus = 2;
			}
			if (s.charAt(i) == '>') {
				while (!reverseQueue.isEmpty()) {
					sb.append(reverseQueue.poll());
				}
				sb.append('>');
				nowStatus = 1;
				continue;
			}
			if (nowStatus == 2) {
				reverseQueue.add(s.charAt(i));
			} else {
				if (s.charAt(i) == ' ') {
					while (!reverseStack.isEmpty()) {
						sb.append(reverseStack.pop());
					}
					sb.append(' ');
				} else {
					reverseStack.add(s.charAt(i));
				}
			}
		}
		if(nowStatus ==1) {
			while (!reverseStack.isEmpty()) {
				sb.append(reverseStack.pop());
			}
		}else {
			while (!reverseQueue.isEmpty()) {
				sb.append(reverseQueue.poll());
			}
		}
		System.out.println(sb);
	}
}
