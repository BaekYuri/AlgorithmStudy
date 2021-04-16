package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.StringTokenizer;

public class BOJ_17453_두개의문 {
	static int N, M;
	static BitSet first;
	static BitSet switches[];
	static BitSet[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		first = new BitSet();
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == '1') {
				first.set(i, true);
			} else {
				first.set(i, false);
			}
		}

		switches = new BitSet[M];
		result = new BitSet[2 * N + 1];
		for (int i = 0; i < M; i++) {
			s = br.readLine();
			switches[i] = new BitSet();
			for (int j = 0; j < N; j++) {
				if (s.charAt(j) == '1') {
					switches[i].set(j, true);
				} else {
					switches[i].set(j, false);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		powerSet(new BitSet(), 0, first);
		for (int i = 0; i < result.length; i++) {
			if (result[i] == null) {
				sb.append(-1).append("\n");
			} else {
				sb.append(getResult(result[i])).append("\n");
			}
		}
		System.out.println(sb);
	}

	static void powerSet(BitSet choosed, int idx, BitSet state) {
		if (idx == M) {
			int t = getYear(state) + N;
			result[t] = new BitSet();
			result[t] = choosed;
			return;
		}
		BitSet choosedClone = (BitSet) choosed.clone();
		choosedClone.set(idx, true);
		BitSet temp = (BitSet) state.clone();
		temp.xor(switches[idx]);
		powerSet(choosedClone, idx + 1, temp);
		powerSet(choosed, idx + 1, state);
	}

	static int getYear(BitSet state) {

		int one = state.cardinality();
		int zero = N - one;
		return one - zero;
	}

	static String getResult(BitSet s) {
		StringBuilder temp = new StringBuilder();
		temp.append(s.cardinality()).append(" ");
		for (int i = 0; i < N; i++) {
			if (s.get(i))
				temp.append(i + 1).append(" ");
		}
		return temp.toString();
	}
}