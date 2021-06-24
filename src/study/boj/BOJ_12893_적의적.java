package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12893_적의적 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		
		int[] team = new int[N+1];
		
		team[first] = 1;
		team[second] = 2;
		
		for(int i=0;i<M-1;i++) {
			st = new StringTokenizer(br.readLine());
			
			first = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());
			
			if(team[first]!=0 && team[first]==team[second]) {
				System.out.println(0);
				return;
			}else if(team[first]!=0) {
				team[second]=team[first]==1?2:1;
			}else if(team[second]!=0) {
				team[first]=team[second]==1?2:1;
			}
		}
		
		System.out.println(1);
	}
}
