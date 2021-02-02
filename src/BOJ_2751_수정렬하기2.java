import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2751_수정렬하기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		int temp;
		for (int n = 0; n < N; n++) {
			temp = Integer.parseInt(br.readLine());
			list.add(temp);
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb.toString());
	}

}
