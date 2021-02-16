package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BOJ_2870_수학숙제 {
	static String[][] read;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		read = new String[N][];
		
		ArrayList<BigInteger> numList = new ArrayList<BigInteger>();

		for (int n = 0; n < N; n++) {
			String input = br.readLine();
			input = input.replaceAll("\\D", " ");
			read[n] = input.split("\\s+");

			for (int i = 0; i < read[n].length; i++) {
				if (!read[n][i].equals("")) {
					numList.add(new BigInteger(read[n][i]));
				}
			}

		}

		Collections.sort(numList, new Comparator<BigInteger>() {
			@Override
			public int compare(BigInteger o1, BigInteger o2) {
				if (o1.compareTo(o2) == 1)
					return 1;
				else if (o1.compareTo(o2) == -1)
					return -1;
				// TODO Auto-generated method stub
				return 0;
			}
		});

		for (int i = 0; i < numList.size(); i++) {
			sb.append(numList.get(i)).append("\n");
		}
		System.out.println(sb.toString());

		br.close();

	}

}