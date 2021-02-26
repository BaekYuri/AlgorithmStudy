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


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int joker = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp == 0) {//조커는 갯수만 세어놓는다
				joker++;
			} else {
				if(!list.contains(temp)) {//조커가 아닌 숫자들은 중복된 값을 받지 않는다
				list.add(temp);
				}
			}
		}
		int result = Integer.MIN_VALUE;
		
		if (list.isEmpty()) {//조커밖에 없다면 답은 조커의개수이다
			result = joker;
		} else {
			Collections.sort(list);
			for (int i = 0; i < list.size(); i++) {
				int nowCnt = 1;
				int nowJoker = joker;
				int now = list.get(i);
				for (int j = i + 1; j < list.size(); j++) {
					if (list.get(j) == now + 1) {//지금 원소가 이전의 원소보다 1 많다면 스트레이트다
						nowCnt++;
						now = list.get(j);
					} else {
						if (nowJoker > 0) {//지금 조커가 남아있다면 조커를 사용한다
							nowJoker--;
							nowCnt++;
							now++;
							j--;
						} else {//없으면 끝이다
							break;
						}

					}
				}

				nowCnt += nowJoker;//남은 조커들을 다 더한다

				result = Integer.max(nowCnt, result);
			}
		}

		System.out.println(result);
	}
}
