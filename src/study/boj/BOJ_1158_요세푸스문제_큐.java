package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스문제_큐{
	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] result = new int[N];
		for(int n=1;n<=N;n++) {
			queue.add(n);
		}
		
		int count =0;
		int i=0;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			count++;
			if(count == K) {
				result[i++] = temp;
				count = 0;
			}else {
				queue.add(temp);
			}
		}
		
		String resStr = Arrays.toString(result);
		resStr = resStr.replace('[', '<');
		resStr = resStr.replace(']', '>');
		
		System.out.println(resStr);
	}
}
