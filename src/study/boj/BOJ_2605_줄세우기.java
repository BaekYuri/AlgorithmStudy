package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2605_줄세우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> student = new Stack<>();
		Stack<Integer> temp = new Stack<>();
		
		for(int i=1;i<=N;i++) {
			int r = Integer.parseInt(st.nextToken());
			while(r>0) {
				temp.push(student.pop());
				r--;
			}
			student.push(i);
			while(!temp.isEmpty()) {
				student.push(temp.pop());
			}
		}
		Iterator<Integer> it = student.iterator();
		StringBuilder sb = new StringBuilder();
		while(it.hasNext()) {
			sb.append(it.next()).append(" ");
		}

		System.out.println(sb);
	}
	
}
