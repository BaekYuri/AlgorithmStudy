package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1327_소트게임2 {
	static int N, K;
	static String input;
	static boolean find = false;
	static String rst;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		input = new String();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			input+= Integer.toString(arr[i]);
		}
		Arrays.sort(arr);
		rst ="";
		for(int i=0;i<N;i++) {
			rst+=Integer.toString(arr[i]);
		}
		int result = bfs();
		if(find) {
			System.out.println(result);
		}else {
			System.out.println(-1);
		}
		
	}
	static int bfs() {
		Queue<String> queue = new LinkedList<>();
		List<String> visited= new ArrayList<>();
		queue.add(input);
		visited.add(input);
		int depth = 0;
		outer: while(!queue.isEmpty()) {
			int size= queue.size();
			while(size-->0) {
				String now = queue.poll();
				if(now.equals(rst)) {
					find = true;
					break outer;
				}
				for(int i=0;i<=N-K;i++) {
					String tmp = switching(now,i);
					if(!visited.contains(tmp)){
						visited.add(tmp);
						queue.add(tmp);
					}
				}
			}
			depth++;
		}
		return depth;
	}
	
	static String switching(String in, int where) {
		StringBuilder sb= new StringBuilder(in);
		int start = where;
		int end = where+K-1;
		while(start<end) {
			char c = sb.charAt(start);
			sb.setCharAt(start, sb.charAt(end));
			sb.setCharAt(end, c);

			start++;
			end--;
		}
		
		return sb.toString();
	}
}
