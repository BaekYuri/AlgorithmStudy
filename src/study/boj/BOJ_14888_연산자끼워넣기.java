package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
	static int N;
	static int[] numbers, cals;
	static int min, max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N];
		cals = new int[4];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		st =new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			cals[i] = Integer.parseInt(st.nextToken());
		}
		permutation(0,numbers[0],cals.clone());
		
		System.out.println(String.format("%d\n%d", max,min));
	}
	static void permutation(int idx, int state, int[] now) {
		if(idx==N-1) {
			min = Math.min(min, state);
			max = Math.max(max, state);
			return;
		}
		for(int i=0;i<4;i++) {
			if(now[i]==0) continue;
			now[i]--;
			switch(i) {
			case 0:	
				permutation(idx+1, state+numbers[idx+1],now);
				break;
			case 1:	
				permutation(idx+1, state-numbers[idx+1],now);	
				break;
			case 2:	
				permutation(idx+1, state*numbers[idx+1],now);		
				break;
			case 3:			
				permutation(idx+1, state/numbers[idx+1],now);
				break;
				
			}
			now[i]++;
		}
	}
}
