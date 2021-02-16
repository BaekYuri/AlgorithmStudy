package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class BOJ_1244_스위치켜고끄기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[] switches;

	public static void main(String[] args) throws NumberFormatException, IOException {

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		switches = new boolean[T + 1];

		String sw = br.readLine();
		st = new StringTokenizer(sw);

		int i = 1;

		while (st.hasMoreTokens()) {
			String temp = st.nextToken();

			if (temp.equals("1")) {
				switches[i] = true;
			}
			i++;
		}

		int stuCnt = Integer.parseInt(br.readLine());
		int[][] students = new int[stuCnt][2];
		for (int cnt = 0; cnt < stuCnt; cnt++) {
			String stuImp = br.readLine();
			st = new StringTokenizer(stuImp);
			students[cnt][0] = Integer.parseInt(st.nextToken());
			students[cnt][1] = Integer.parseInt(st.nextToken());

			if (students[cnt][0] == 1) {
				// 남자면
				int s = students[cnt][1];
				while (s < switches.length) {
					switches[s] = !switches[s];
					s += students[cnt][1];
				}

			} else {
				// 여자면
				switches[students[cnt][1]] = !switches[students[cnt][1]];
				for (int s = 1; students[cnt][1] - s > 0 && students[cnt][1] + s < switches.length; s++) {
					if (switches[students[cnt][1] - s] == switches[students[cnt][1] + s]) {
						switches[students[cnt][1] - s] = !switches[students[cnt][1] - s];
						switches[students[cnt][1] + s] = !switches[students[cnt][1] + s];

					} else {
						break;
					}
				}

			}

		}

		int count = 0;
		for (int r = 1; r < switches.length; r++) {
			if (switches[r]) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}
			count++;
			if (count == 20) {
				sb.append("\n");
				count = 0;
			}
		}


		System.out.println(sb);
	}

}