import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BOJ_1181_단어정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		String temp;
		for (int n = 0; n < N; n++) {
			temp = br.readLine();
			if (!list.contains(temp)) {
				list.add(temp);
			}
		}
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length()) {
					return 1;
				} else if (o1.length() < o2.length()) {
					return -1;
				} else {
					return o1.compareTo(o2);
				}
			}
		});
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb.toString());
	}

}