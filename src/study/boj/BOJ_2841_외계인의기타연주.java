package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2841_외계인의기타연주 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		Stack<Integer> line[] = new Stack[7];
		for(int i=1;i<=6;i++) {
			line[i] = new Stack<>();
		}
		int count =0;
		for(int i=0;i<N;i++) {
			 st = new StringTokenizer(br.readLine());
			 int num = Integer.parseInt(st.nextToken());
			 int fret = Integer.parseInt(st.nextToken());
			 if(line[num].isEmpty()) {
				 line[num].push(fret);
				 count++;
			 }else {
				 if(line[num].peek() == fret) {
					 continue;
				 }else {
					 while(!line[num].isEmpty() &&line[num].peek()>fret) {
						 line[num].pop();
						 count++;
					 }
					 if(line[num].isEmpty() ||line[num].peek() != fret) {
						 line[num].push(fret);
						 count++;
					 }
				 }
			 }
			 
			 
		}
		System.out.println(count);
	}
}
