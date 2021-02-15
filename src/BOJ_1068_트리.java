import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1068_트리 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> link[] = new Stack[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int root = 0;

		for (int i = 0; i < N; i++) {
			link[i] = new Stack<>();
		}
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp == -1) {
				root = i;
			} else {
				link[temp].push(i);
			}
		}
		
		int result = 0;
		int disconnect = Integer.parseInt(br.readLine());
		if(disconnect ==root) {
			System.out.println(result);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!link[i].isEmpty() && link[i].remove((Object)disconnect)) {
				break;
			}
		}

		boolean[] visited = new boolean[N];
		
		Stack<Integer> stack = new Stack<>();
		stack.add(root);
		while(!stack.isEmpty()) {
			int temp = stack.pop();
			if(visited[temp]) continue;
			visited[temp] = true;
			if(link[temp].isEmpty()) {
				result++;
			}else {
				stack.addAll(link[temp]);
			}
		}
		
		System.out.println(result);
	}
}
