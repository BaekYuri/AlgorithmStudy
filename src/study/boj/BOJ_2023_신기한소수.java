package study.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2023_신기한소수 {
	static int N;
	static List<Integer> sosuList = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		scan.close();
		Queue<Integer> queue[] = new LinkedList[N];
		for(int i=0;i<N;i++) {
			queue[i]= new LinkedList<>();
		}
		queue[0].add(2);
		for(int i=3;i<10;i+=2) {
			if(isSosu(i)) {
				queue[0].add(i);
			}
		}
		if(N==1) {
			StringBuilder sb = new StringBuilder();
			while(!queue[0].isEmpty()) {
				sb.append(queue[0].poll()).append("\n");
			}
			System.out.println(sb);
			return;
		}
		
		for(int i=0;i<N-1;i++) {
			while(!queue[i].isEmpty()) {
				int now = queue[i].poll();
				for(int t=1;t<10;t+=2) {
					int temp = (now*10)+t;

					if(isSosu(temp)) {
						queue[i+1].add(temp);
					}
				}
			}
		}
		sosuList.addAll(queue[N-1]);
		Collections.sort(sosuList);
		StringBuilder sb = new StringBuilder();
		for(int i: sosuList) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
		
	}
	static boolean isSosu(int n) {
		
		for(int i=3;i<n/2;i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
}
