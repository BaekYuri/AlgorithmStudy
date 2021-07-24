package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_20437_문자열게임 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++) {
			int shortLength = 10001;
			int longLength= -1;
			int[] count = new int['z'-'a'+1];
			
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			ArrayList<Integer> indexOf[] = new ArrayList['z'-'a'+1];
			for(int i=0; i<'z'-'a'+1; i++) {
				indexOf[i] = new ArrayList<>();
			}
			
			for(int i=0, size=W.length(); i<size;i++) {
				char now = W.charAt(i);
				int idx = now-'a';
				
				count[idx]++;
				indexOf[idx].add(i);
				if(count[idx]>=K) {
					int first = indexOf[idx].get(count[idx]-K);
					
					int length = i - first;
					
					shortLength = Math.min(length, shortLength);
					longLength = Math.max(length, longLength);
				}
				
			}
			
			if(longLength == -1) {
				sb.append(-1).append("\n");
			}else {
				sb.append(shortLength+1).append(" ").append(longLength+1).append("\n");
			}
		}
		System.out.println(sb);
	}
}
