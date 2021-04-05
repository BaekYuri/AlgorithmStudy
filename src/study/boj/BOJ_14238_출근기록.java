package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ_14238_출근기록 {
	static int[] count;
	static int length;
	static char[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		length = input.length();
		count = new int[3];
		for (int i = 0; i < length; i++) {
			count[input.charAt(i) - 'A']++;
		}
		
		dfs(new char[length], count.clone(), 0);
		if(result==null) {
			System.out.println(-1);
		}else {
			StringBuilder sb = new StringBuilder();
			for(char c: result) {
				sb.append(c);
			}
			System.out.println(sb);
		}
		
	}

	static void dfs(char[] before, int[] now, int idx) {
		if(now[1]-1>now[0]+now[2] || (now[2]-1)*2>now[0]+now[1] ||(now[2]<=now[1] && now[2]-1>now[0])) {
			return;
		}
		if (idx == length) {
			result = before;
			return;
		}
		if (now[2] > 0) {
			if (idx - 1 >= 0 && before[idx - 1] == 'C') {
			} else if (idx - 2 >= 0 && before[idx - 2] == 'C') {
			} else {
				now[2]--;
				before[idx] = 'C';
				dfs(before, now, idx + 1);
				now[2]++;
				if(result !=null) return;
			}
		}
		
		if (now[1] > 0) {
			if (idx - 1 >= 0 && before[idx - 1] == 'B') {
			} else {
				now[1]--;
				before[idx] = 'B';
				dfs(before, now, idx + 1);
				now[1]++;
				if(result !=null) return;
			}
		}
		if (now[0] > 0) {
			now[0]--;
			before[idx] = 'A';
			dfs(before, now, idx + 1);
			now[0]++;
			if(result !=null) return;
		}
	}
}
