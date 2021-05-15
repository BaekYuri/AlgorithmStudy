package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9080_PC방요금 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T  =Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String start = st.nextToken();
			int usedTime = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(start,":");
			int startHour = Integer.parseInt(st.nextToken());
			int startMin = Integer.parseInt(st.nextToken());
			
			int startTime = startHour*60+startMin;
			int endTime = startTime+usedTime;
			
			int price = 0;
			while(startTime<endTime) {
				int pm8 = 20*60;
				
			}
		}
		System.out.println(sb);
	}
}
