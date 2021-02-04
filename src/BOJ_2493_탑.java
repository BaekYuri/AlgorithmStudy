import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Integer> tops = new Stack<>();
		Stack<Integer> topIdx = new Stack<>();
		Stack<Integer> topsNum = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		String s = br.readLine();
		
		StringTokenizer st = new StringTokenizer(s);
		int before = Integer.parseInt(st.nextToken());// 1
		int top ;
		int nowIdx = 1;
		topIdx.add(0);
		tops.add(before);
		topsNum.add(1);
		while (st.hasMoreTokens()) {
			top = Integer.parseInt(st.nextToken());
			nowIdx++;
			while (!tops.isEmpty() &&tops.peek() <= top) {
				tops.pop();
				topsNum.pop();
				
			}
			if(tops.isEmpty()) {
				topIdx.push(0);
				tops.push(top);
				topsNum.add(nowIdx);
			}else {
				tops.push(top);
				topIdx.push(topsNum.peek());
				topsNum.add(nowIdx);
				
			}

			
		}

		StringBuilder sb = new StringBuilder();
		for (int a : topIdx) {
			sb.append(a).append(" ");
		}
		System.out.println(sb);
	}
}
