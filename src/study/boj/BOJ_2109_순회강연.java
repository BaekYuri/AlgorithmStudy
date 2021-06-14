package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2109_순회강연 {
	static int N;
	static PriorityQueue<int[]> collage;
	static int max=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		collage = new PriorityQueue<>((o1,o2)->{
			if(o1[1]==o2[1]) {
				return Integer.compare(o2[0], o1[0]);
			}else {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int pay = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			collage.add(new int[] {pay,day});
		}
		
		int now = 1;
		while(!collage.isEmpty()) {
			int[] pop = collage.poll();
			if(pop[1]<now) continue;
			max+=pop[0];
			now++;
		}

		System.out.println(max);
	}
	
}
