import java.util.Scanner;

public class BOJ_9012_괄호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			String str = sc.next();

			
			boolean change = isVPS(str);

			
			if (change) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

	static boolean isVPS(String s) {

		String copy = s;
		while (copy.length() != 0) {
			if (copy.contains("()")) {
				copy = copy.replace("()", "");


			} else {
				return false;
			}

		}
		return true;
	}

}
