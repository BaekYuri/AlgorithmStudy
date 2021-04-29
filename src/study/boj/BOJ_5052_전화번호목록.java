package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class BOJ_5052_전화번호목록 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			String[] arr= new String[N];
			
			for(int i=0;i<N;i++) {
				arr[i] = br.readLine();
			}
			Arrays.sort(arr, (o1,o2)->{return Integer.compare(o1.length(), o2.length());});
			
			int minLength = arr[0].length();
			int maxLength = arr[0].length();
			
			HashSet<String> set = new HashSet<>();
			set.add(arr[0]);
			boolean result = true;
			outer: for(int i=1;i<N;i++) {
				
				for(int j=minLength;j<=maxLength;j++) {
					String sub = arr[i].substring(0, j);
					if(set.contains(sub)) {
						result = false;
						break outer;
					}
				}
				maxLength = arr[i].length();
				set.add(arr[i]);
			}
			sb.append(result?"YES":"NO").append("\n");
		}
		System.out.println(sb);
	}
}
