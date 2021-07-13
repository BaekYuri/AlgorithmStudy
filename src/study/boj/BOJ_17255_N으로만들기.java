package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_17255_N으로만들기 {
	static String N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = br.readLine();
		
		
		int result = 0;
		
		Queue<String> queue = new LinkedList<>();
		
		queue.add(new String(N));
		
		int depth = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			if(depth == N.length()-1) {
				result = size;
				break;
			}
			while(size-->0) {
				String now = queue.poll();
				String left = now.substring(1);
				String right = now.substring(0, now.length()-1);
				
				if(left.equals(right)) {
					queue.add(left);
				}else {
					queue.add(left);
					queue.add(right);
				}
			}
			depth++;
		}
		System.out.println(result);
	}
	
}
