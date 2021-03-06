
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1327_소트게임 {
	static int N, K;
	static int[] input;
	static List<arrayNlevel> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		input = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		if (N == 1 || isUpper(input)) {
			System.out.println(0);
			return;
		}

		int result = 0;
		boolean isChange = false;
		Queue<arrayNlevel> queue = new LinkedList<>();
		queue.add(new arrayNlevel(input, 0));
		outer: while (!queue.isEmpty()) {
			arrayNlevel temp = queue.poll();
			int[] tempArray = temp.array;
			int tempLevel = temp.level;
			if (list.contains(temp)) {
				continue;
			}
			list.add(temp);
			for (int i = 0; i <= N - K; i++) {
				int[] ta = tempArray.clone();
				ta = swap(i, ta);
				
				if (isUpper(ta)) {
					isChange = true;
					result = tempLevel + 1;
					break outer;
				} else {
					arrayNlevel to = new arrayNlevel(ta, tempLevel+1);
					if (!list.contains(to)) {
						queue.add(to);
					}
				}
			}

		}
		if (isChange) {
			System.out.println(result);
		} else {
			System.out.println(-1);
		}

	}

	static int[] swap(int n, int[] arr) {
		int k = n + K - 1;
		while (n < k) {
			int temp = arr[n];
			arr[n] = arr[k];
			arr[k] = temp;
			n++;
			k--;
		}
		return arr;
	}

	static boolean isUpper(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	static class arrayNlevel {
		int[] array;
		int level;

		public arrayNlevel(int[] array, int level) {
			super();
			this.array = array;
			this.level = level;

		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(array);
			result = prime * result + level;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			arrayNlevel other = (arrayNlevel) obj;
			if (!Arrays.equals(array, other.array))
				return false;
			return true;
		}

	}
}
