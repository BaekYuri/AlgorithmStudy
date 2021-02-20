package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_5587_카드캡터상근이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<Integer> myCard = new ArrayList<>();
		List<Integer> yourCard = new ArrayList<>();

		boolean[] card = new boolean[2 * N + 1];
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			myCard.add(temp);
			card[temp] = true;
		}
		Collections.sort(myCard);
		;
		for (int i = 1; i <= 2 * N; i++) {
			if (!card[i]) {
				yourCard.add(i);
			}
		}

		int nowCard = 0;
		while (myCard.size() > 0 && yourCard.size() > 0) {
			for (int i = 0; i <= myCard.size(); i++) {
				if (i == myCard.size()) {
					nowCard = 0;
				} else {
					if (myCard.get(i) > nowCard) {
						nowCard = myCard.remove(i);
						break;
					}
				}
			}
			if(myCard.size() ==0) {
				break;
			}
			for (int i = 0; i <= yourCard.size(); i++) {
				if (i == yourCard.size()) {
					nowCard = 0;
				} else {
					if (yourCard.get(i) > nowCard) {
						nowCard = yourCard.remove(i);
						break;
					}
				}
			}
			if(yourCard.size() ==0) {
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(yourCard.size()).append("\n").append(myCard.size()).append("\n");

		System.out.println(sb);

		return;
	}
}
