package study.boj;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11866_요세푸스문제0 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		LinkedList<Integer> queue = new LinkedList<>();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			q.add(i);
		}
		int cntK = 0;
		while(!q.isEmpty()) {
			int temp = q.poll();
			cntK++;
			if(cntK == K) {
				queue.add(temp);
				cntK=0;
			}else {
				q.add(temp);
			}
		}


		String s = queue.toString();
		s = s.replace("[", "<");
		s = s.replace("]", ">");
		System.out.println(s);

	}
}
