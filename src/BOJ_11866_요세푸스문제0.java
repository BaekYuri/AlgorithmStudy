import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_11866_요세푸스문제0 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		LinkedList<Integer> circle[] = new LinkedList[N + 1];
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i <= N; i++) {
			circle[i] = new LinkedList<>();
		}
		for (int i = 1; i <= N; i++) {
			if (i == N) {
				circle[i].add(1);
			} else {
				circle[i].add(i + 1);
			}
			
		}

		int now = 1;
		int i, a=1;
		Iterator<Integer> it;
		while (queue.size() < N) {
			it = circle[now].listIterator();
			i = it.next();//현재 사람의 다음 사람
			now = i;
			if (!queue.contains(now)) {//다음 사람이 빠진 사람이 아니라면
				a++; //한칸 간걸로 친다
				if (a == K) { //K칸 가서 만난 사람이면
					queue.add(now);//빠지게 하자
					a=1;
					it = circle[now].listIterator();
					i = it.next();
					now = i;
				}
			}else {
				now = i;
			}
			System.out.println(now+" "+ a);
		}
		String s = queue.toString();
		s = s.replace("[", "<");
		s = s.replace("]", ">");
		System.out.println(s);

	}
}
