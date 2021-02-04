import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Integer> tops = new Stack<>();
		Stack<Integer> topIdx = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int before = Integer.parseInt(st.nextToken());
		int top = Integer.parseInt(st.nextToken());
		int nowIdx = 1;
		while (st.hasMoreTokens()) {
			if(before>top) {
				tops.push(before);
				tops.push(nowIdx++);
				before = top;
				top = Integer.parseInt(st.nextToken());
			}
			
		}
		
//		int nowTop;
//		int temp;
//		while (!tops.isEmpty()) {
//			nowTop = tops.pop();
//			while (true) {
//				if (tops.isEmpty()) {
//					result[--num] = 0;
//					while (!tempTops.isEmpty()) {
//						tops.push(tempTops.pop());
//					}
//					break;
//				}
////				int temp = tops.pop();
//				
//				if (nowTop <= tops.peek()) {
////					tops.push(temp);
//					result[--num] = tops.size();
//					while (!tempTops.isEmpty()) {
//						tops.push(tempTops.pop());
//					}
//					break;
//				} else {
//					temp=tops.pop();
//					tempTops.push(temp);
//				}
//			}
//		}
		StringBuilder sb = new StringBuilder();
		for(int a: topIdx) {
			sb.append(a).append(" ");
		}
		System.out.println(sb);
	}
}
