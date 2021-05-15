package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9177_단어섞기 {
	static boolean result;
	static String first, second, third;
	static int firstLength, secondLength, thirdLength;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			
			result = false;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			first = st.nextToken();
			second = st.nextToken();
			third = st.nextToken();
			
			int[][] count = new int[26][2];
			firstLength = first.length();
			secondLength = second.length();
			thirdLength = third.length();
			for(int i=0;i<firstLength;i++) {
				char temp = first.charAt(i);
				if(temp>='a' &&temp<='z') {
					count[temp-'a'][0]--;
				}else {
					count[temp-'A'][1]--;
				}
			}
			for(int i=0;i<secondLength;i++) {
				char temp = second.charAt(i);
				if(temp>='a' &&temp<='z') {
					count[temp-'a'][0]--;
				}else {
					count[temp-'A'][1]--;
				}
			}
			for(int i=0;i<thirdLength;i++) {
				char temp = third.charAt(i);
				if(temp>='a' &&temp<='z') {
					count[temp-'a'][0]++;
				}else {
					count[temp-'A'][1]++;
				}
			}
			boolean isSame = true;
			for(int i=0;i<26;i++) {
				if(count[i][0]!=0 || count[i][1]!=0) {
					isSame = false;
					break;
				}
			}
			if(isSame) {
				find(0,0,0);
			}
			sb.append("Data set ").append(t).append(": ").append(result?"yes":"no").append("\n");
		}
		System.out.println(sb);
	}
	
	static void find(int idx, int firstIdx, int secondIdx) {
		if(result) return;
		if(idx == thirdLength) {
			result = true;
			return;
		}
		char temp = third.charAt(idx);
		if(firstIdx<firstLength && first.charAt(firstIdx)==temp) {
			find(idx+1, firstIdx+1, secondIdx);
		}
		if(secondIdx<secondLength && second.charAt(secondIdx)== temp) {
			find(idx+1, firstIdx,secondIdx+1);
		}
		
	}
}
