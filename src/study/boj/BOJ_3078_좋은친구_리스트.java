package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3078_좋은친구_리스트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //우리반 학생 수
		int K = Integer.parseInt(st.nextToken()); //등수 차이
		List<Integer> list = new ArrayList<>();
		
		
		
		for(int t=0;t<N;t++) {
			String s = br.readLine();
			list.add(s.length());
		}
		long result= 0;
		int[] slide = new int[21];
		
		int first = list.get(0);
		for(int i=0;i<K+1;i++) {
			int firstLength = list.get(i);
			slide[firstLength]++;
		}
		result += --slide[first];
		for(int start=1;start<list.size()-1;start++) {
			int nowLength = list.get(start);
			if((start+K)<list.size()) {
				int plusLength = list.get(start+K);
				slide[plusLength]++;
			}
			result += --slide[nowLength];
		}
		System.out.println(result);
	}
}
