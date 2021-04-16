package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	static int N;
	static int[] gu;
	static List<Integer> connect[];
	static int result = Integer.MAX_VALUE;
	static int count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		gu = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			gu[i] = Integer.parseInt(st.nextToken());
		}
		connect = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			connect[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			for (int j = 0; j < t; j++) {
				connect[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		powerset(new boolean[N + 1], 0, 1, 0, 0);
		if(result==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
	}

	static void powerset(boolean[] choosed, int cnt, int idx, int left, int right) {
		if (count > (1 << N - 1))
			return;
		if (idx == N + 1) {

			if (cnt != 0 && cnt != N && canConnect(choosed)) {
				result = Math.min(result, Math.abs(left - right));
			}
			return;
		}
		count++;
		choosed[idx] = true;
		powerset(choosed, cnt + 1, idx + 1, left + gu[idx], right);
		choosed[idx] = false;
		powerset(choosed, cnt, idx + 1, left, right + gu[idx]);
	}

	static boolean canConnect(boolean[] choosed) {
		int leftStart = 0;
		int rightStart = 0;
		for (int i = 1; i <= N; i++) {
			if (choosed[i])
				leftStart = i;
			else
				rightStart = i;
			if (leftStart != 0 && rightStart != 0)
				break;
		}
		int visited = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(leftStart);
		visited |= (1 << leftStart - 1);
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 0; i < connect[now].size(); i++) {
				int temp = connect[now].get(i);
				if (choosed[temp] && (visited & (1 << temp - 1)) == 0) {
					visited |= (1 << temp - 1);
					queue.add(temp);
				}
			}
		}
		queue.add(rightStart);
		visited |= (1 << rightStart - 1);
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 0; i < connect[now].size(); i++) {
				int temp = connect[now].get(i);
				if (!choosed[temp] && (visited & (1 << temp - 1)) == 0) {
					visited |= (1 << temp - 1);
					queue.add(temp);
				}
			}
		}
		if (visited == (1 << N) - 1) {
			return true;
		} else {
			return false;
		}
	}
}
