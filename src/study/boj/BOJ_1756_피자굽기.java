package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1756_피자굽기 {
	static int D, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int[] oven = new int[D];
		int[] minOven = new int[D];
		int minR = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<D;i++) {
			oven[i] = Integer.parseInt(st.nextToken());
			minOven[i] = minR;
			if(oven[i]<minR) {
				minR = oven[i];
				minOven[i] = minR;
			}
		}
		int nowIdx = D-1;
		boolean allPizza = true;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int pizza = Integer.parseInt(st.nextToken());
			boolean found = false;
			for(int start=nowIdx;start>=0;start--) {
				if(minOven[start]>=pizza) {
					found = true;
					nowIdx = start-1;
					break;
				}
			}
			if(!found) {
				allPizza = false;
				break;
			}
		}
		
		if(allPizza) {
			System.out.println(nowIdx+2);
		}else {
			System.out.println(0);
		}
	}
}
