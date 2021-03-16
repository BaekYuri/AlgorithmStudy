package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	static char[] alpa;
	static int L, C;
	static List<String> resultList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpa = new char[C];
		
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			alpa[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alpa);
		
		combination(L,new char[L], 0);
		Collections.sort(resultList);
		StringBuilder sb=  new StringBuilder();
		for(String s:resultList) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
	static void combination(int toChoose, char[] choosed, int start) {
		if(toChoose ==0) {
			int jaum=0, moum=0;
			for(int t=0;t<choosed.length;t++) {
				if(choosed[t]=='a'||choosed[t]=='e'||choosed[t]=='i'||choosed[t]=='o'||choosed[t]=='u') {
					moum++;
				}else {
					jaum++;
				}
			}
			if(moum>=1 && jaum>=2) {
				resultList.add(String.copyValueOf(choosed));
			}
			return;
		}
		for(int i=start;i<alpa.length;i++) {
			
			choosed[choosed.length-toChoose]=alpa[i];
			combination(toChoose-1,choosed,i+1);
			
		}
	}
}
