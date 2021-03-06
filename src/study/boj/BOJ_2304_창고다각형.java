package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2304_창고다각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] length = new int[N][2];
		int[] room = new int[1001];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			length[i][0] = Integer.parseInt(st.nextToken());
			length[i][1] = Integer.parseInt(st.nextToken());
			room[length[i][0]] = length[i][1];
		}
		Arrays.sort(length, (o1,o2)->{return o1[0]-o2[0];});
		Stack<int[]> stack = new Stack<>();
		int result = length[0][1];
		stack.add(length[0]);
		for(int i=length[0][0]+1; i<length[N-1][0];i++) {
			if(room[i]<=stack.peek()[1]) {
				result+=stack.peek()[1];
			}else {
				result+=room[i];
				stack.pop();
				stack.push(new int[] {i,room[i]});
			}
		}
		
	}
}
