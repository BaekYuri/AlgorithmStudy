package study.boj;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1463_1로만들기 {
	static int N;

	static LinkedList<Integer>[] list;
	static int[] result;
	static LinkedList<Integer> queue = new LinkedList<>();

	static void calculate() {
		queue.add(1);
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			int count = 0;
			while (!list[temp].isEmpty()) {
				int temp2 = list[temp].poll();
				if (temp2 <= N) {
					count++;
					if(count <result[temp2])
						result[temp2]=count;
					queue.add(temp2);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.close();
		list = new LinkedList[N + 1];
		result = new int[N + 1];
		for (int i = 1; i < N; i++) {
			list[i] = new LinkedList<>();
			list[i].add(i * 3);
			list[i].add(i * 2);
			list[i].add(i + 1);

//			if(i%3==0) {
//				list[i].add(i/3);
//			}
//			if(i%2==0) {
//				list[i].add(i/2);
//			}
//			list[i].add(i-1);	
		}
		

//		int X = sc.nextInt();
//		sc.close();
//		int count = 0;
//		int A = 1;
//		while (X != 1) {
//			if (X % 3 == 0) {
//				X /= 3;
//			} else {
//				if ((X - 1) % 3 == 0) {
//					count++;
//					X = (X - 1) / 3;
//				} else {
//					if (X % 2 == 0) {
//						if ((X - 1) % 3 == 0) {
//							count++;
//							X = (X - 1) / 3;
//						} else {
//							X /= 2;
//						}
//					} else {
//						X--;
//					}
//				}
//			}
//			count++;
//		}
//		System.out.println(count);
	}
}
