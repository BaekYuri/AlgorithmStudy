package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {
	static int N;
	static int S;
	static int[] line;
	static int count = 0;
	static List<int[]> intList = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		line = new int[N];
		s = br.readLine();
		st = new StringTokenizer(s);
		for (int i = 0; st.hasMoreTokens(); i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}
		if(line.length ==1) {
			if(line[0]==S) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
			return;
		}
		powerSet(new boolean[line.length], 0);

		System.out.println(count);
	}
	static void powerSet(boolean [] visited, int cnt) {
		if(cnt == line.length) {
			int result =0;
			int trueCnt =0;
			for(int i=0;i<visited.length;i++) {
				if(visited[i]) {
					trueCnt ++;
					result += line[i];
				}
			}
			if(trueCnt != 0 && result ==S) count++;
			return;
		}
		
		visited[cnt] = true;
		powerSet(visited,cnt+1);
		visited[cnt] = false;
		powerSet(visited,cnt+1);
	}
}
