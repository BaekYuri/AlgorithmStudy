package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_3078_좋은친구_리스트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //우리반 학생 수
		int K = Integer.parseInt(st.nextToken()); //등수 차이
		ArrayList<Integer> charLeng[] = new ArrayList[21];
		for(int i=2;i<=20;i++) {
			charLeng[i] = new ArrayList<>();
		}
		
		
		for(int t=0;t<N;t++) {
			String s = br.readLine();
			charLeng[s.length()].add(t);
		}
		int result=0;
		for(int l = 2; l<=20;l++) {
			for(int i=0;i<charLeng[l].size()-1;i++) {
				int startIdx= charLeng[l].get(i);
				for(int j=i+1;j<charLeng[l].size();j++) {
					int endIdx = charLeng[l].get(j);
					if(endIdx-startIdx>K) break;
					result++;
				}
			}
		}
		
		System.out.println(result);
		return;
	}
}
