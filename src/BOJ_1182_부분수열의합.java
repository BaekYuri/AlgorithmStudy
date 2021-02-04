import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {
	static int N;
	static int S;
	static int[] line;
	static int count = 0;
	static List<int[]> intList = new ArrayList<>();

	static void isS(int startIdx, int[] newLine) {
		if (newLine.length + startIdx > line.length) {
			return;
		}
		int sum = 0;
		for (int i = startIdx; i < newLine.length + startIdx; i++) {
			newLine[i - startIdx] = line[i];
			sum += line[i];
		}
		if (!intList.contains(newLine)) {
			intList.add(newLine);
			if (sum == S) {
				count++;
			}
		}

		isS(startIdx + 1, newLine);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		line = new int[N];
		s = br.readLine();
		st = new StringTokenizer(s);
		for (int i = 0; st.hasMoreTokens(); i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N; i++) {
			isS(0, new int[i]);
		}
		System.out.println(count);
	}
}
