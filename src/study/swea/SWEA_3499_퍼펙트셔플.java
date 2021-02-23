package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_3499_퍼펙트셔플 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			Queue<String> left = new LinkedList<String>();
			Queue<String> right = new LinkedList<String>();
			Queue<String> result = new LinkedList<String>();
			int leftSize;
			if (N % 2 == 1)
				leftSize = N / 2 + 1;
			else
				leftSize = N / 2;

			
			for (int i = 0; i < leftSize; i++) {
				left.offer(st.nextToken());
			}
			for(int i= leftSize;i<N;i++) {
				right.offer(st.nextToken());
			}

			for(int i=0; i<N;i++) {
				if(i%2 == 0) {
					result.offer(left.poll());
				}else {
					result.offer(right.poll());
				}
			}
			sb.append("#").append(t).append(" ");
			for(String a : result) {
				sb.append(a).append(" ");
			}
			sb.append("\n");

		}
		System.out.println(sb);
	}
}
