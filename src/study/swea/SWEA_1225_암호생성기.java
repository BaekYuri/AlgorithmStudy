package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225_암호생성기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue;
		StringBuilder sb = new StringBuilder();
		String s =null;
		int t=1;
		for(int i=1;i<=10;i++) {
			s=br.readLine();
			
			t = Integer.parseInt(s);
			s= br.readLine();
			queue = new LinkedList<Integer>();
			int count = 1;
			StringTokenizer st = new StringTokenizer(s);
			while(st.hasMoreTokens()) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			while(true) {
				int temp =queue.poll()-count;
				if(temp<=0) {
					temp = 0;
					queue.offer(temp);
					break;
				}
				queue.offer(temp);
				if(count==5) count=1;
				else count++;
				
				
			}
			sb.append("#").append(t).append(" ");
			for(int a:queue) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}
