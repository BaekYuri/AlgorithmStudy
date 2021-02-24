package study.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 정올_1205_조커 {
	static Set<Integer> number = new HashSet<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int joker = 0;
		for (int i = 0; i < T; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp == 0) {
				joker++;
			} else {
				number.add(temp);
			}
		}
		int result = Integer.MIN_VALUE;
		List<Integer> list = new ArrayList<>();
		list.addAll(number);
		if (list.isEmpty()) {
			result = joker;
		} else {
			Collections.sort(list);
			for (int i = 0; i < list.size(); i++) {
				int nowCnt = 1;
				int nowJoker = joker;
				int now = list.get(i);
				for (int j = i + 1; j < list.size(); j++) {
					if (list.get(j) == now + 1) {
						nowCnt++;
						now = list.get(j);
					} else {
						if (nowJoker > 0) {
							nowJoker--;
							nowCnt++;
							now++;
							j--;
						} else {
							break;
						}

					}
				}

				nowCnt += nowJoker;

				result = Integer.max(nowCnt, result);
			}
		}

		System.out.println(result);
	}
}
