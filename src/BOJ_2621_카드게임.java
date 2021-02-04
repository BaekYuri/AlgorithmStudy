import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2621_카드게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] color = new int[4];
		Map<Integer, Integer> number = new HashMap<Integer, Integer>();
		for (int i = 0; i < 5; i++) {
			String getCard = br.readLine();
			StringTokenizer st = new StringTokenizer(getCard);

			String temp = st.nextToken();
			switch (temp) {// 받은 카드값에 따라 색깔별로 몇개씩 있는지 추가
			case "R":
				color[0]++;
				break;
			case "B":
				color[1]++;
				break;
			case "Y":
				color[2]++;
				break;
			case "G":
				color[3]++;
				break;
			}

			temp = st.nextToken();// 숫자에 따라 맵(number)에 카드숫자(key) 개수(value)저장
			int tempInt = Integer.parseInt(temp);
			if (!number.containsKey(tempInt)) {
				number.put(tempInt, 1);
			} else {
				number.put(tempInt, number.get(tempInt).intValue() + 1);
			}

		}
		int bonusScore = 0;
		Iterator<Integer> intKey = number.keySet().iterator();

		int min = intKey.next(); // Key 값으로 정렬 후 최솟값, 최댓값 구해놓기
		int max = 0;
		int cnt = 1;

		while (intKey.hasNext()) {
			max = intKey.next();

			cnt++;
		}

		bonusScore = 100 + max;// 9 어떤 경우에도 해당하지 않을 때 (미리초기화)
		intKey = number.keySet().iterator();

		if (number.containsValue(2)) {// 숫자가 같은 카드가 2개가 있는 경우

			if (number.size() == 3) {// 7 카드 5장 중 2장의 숫자가 같고 또 다른 2장의 숫자가 같을 때
				int[] tt = new int[number.size()];
				for (int a = 0; a < number.size(); a++) {
					tt[a] = intKey.next();
					if (number.get(tt[a]).intValue() == 1) {
						tt[a] = 0;
					}
				}
				int bigNum = 0;
				for (int a = 0; a < number.size() - 1; a++) {
					bigNum = Integer.max(tt[a], tt[a + 1]);

				}
				bonusScore = 300 + (bigNum * 9);
				for (int a = 0; a < number.size(); a++) {
					bonusScore += tt[a];
				}
			} else {// 8 카드 5장 중 2장의 숫자가 같을 때
				for (int a = 0; a < number.size(); a++) {
					int tt = intKey.next();
					if (number.get(tt).intValue() == 2) {
						bonusScore = 200 + tt;
						break;
					}
				}
			}

		}

		intKey = number.keySet().iterator(); // 목록 사용했으니 다시 초기화
		if (number.containsValue(3)) {// 6 카드 5장 중 3장의 숫자가 같을 때
			for (int a = 0; a < number.size(); a++) {
				int tt = intKey.next();
				if (number.get(tt).intValue() == 3) {
					bonusScore = 400 + tt;
					break;
				}

			}
		}

		if ((max - min) == 4 && cnt == 5) {// 5 카드 5장의 숫자가 연속적일 때.
			bonusScore = 500 + max;
		}
		if (number.containsValue(3) && number.containsValue(2)) {// 3 카드 5장 중 3장의 숫자가 같고 나머지 2장도 숫자가 같을 때

			if (number.get(min).intValue() == 3) {
				bonusScore = 700 + (min * 10) + max;

			} else {
				bonusScore = 700 + (max * 10) + min;

			}

		}
		if (number.containsValue(4)) {// 2 카드 5장 중 4장의 숫자가 같을 때

			if (number.get(min).intValue() == 4) {
				bonusScore = 800 + min;

			} else {
				bonusScore = 800 + max;

			}
		}

		for (int a = 0; a < 4; a++) {// 1, 4 
			if (color[a] == 5) {

				if ((max - min) == 4 && cnt == 5) {//1 카드 5장이 모두 같은 색이면서 숫자가 연속적일 때
					bonusScore = 900 + max;

				} else {							//4 5장의 카드 색깔이 모두 같을 때
					bonusScore = 600 + max;

				}
				break;

			}
		}

		System.out.println(bonusScore);
	}
}
