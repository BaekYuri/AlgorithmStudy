import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_3052_나머지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<10;i++) {
			int t = Integer.parseInt(br.readLine());
			t = t%42;
			set.add(t);
		}
		System.out.println(set.size());
	}
}
