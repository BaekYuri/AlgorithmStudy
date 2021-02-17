package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_제로 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<K;i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp==0) {
				stack.pop();
			}else {
				stack.push(temp);
			}
		}
		int sum = 0;
		for(int t: stack) {
			sum+=t;
		}
		System.out.println(sum);
	}
}
