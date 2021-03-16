package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4008_숫자만들기 {
	static int N;
	static int[] numBlock;
	static int[] calBlock;
	
	static int min,max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			int result=0;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			N = Integer.parseInt(br.readLine());
			
			numBlock = new int[N];
			calBlock = new int[4];
			
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int i=0, a=0;i<4;i++) {
				calBlock[i]= Integer.parseInt(st.nextToken());
				
			}
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				numBlock[i] = Integer.parseInt(st.nextToken());
			}
			
			calculate(new int[N-1], calBlock, N-1);
			
			result = max - min;
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void calculate(int[] choosed, int[] nowBlock, int toChoose) {
		if(toChoose==0) {
			int result=0;
			if(numBlock[1]==0 && choosed[0]==3) return;
			switch(choosed[0]) {
			case 0:
				result = numBlock[0]+numBlock[1];
				break;
			case 1:
				result = numBlock[0]-numBlock[1];
				break;
			case 2:
				result = numBlock[0]*numBlock[1];
				break;
			case 3:
				result = numBlock[0]/numBlock[1];
				break;
			}
			
			for(int i=1;i<N-1;i++) {
				if(numBlock[i+1]==0 && choosed[i]==3) return;
				switch(choosed[i]) {
				case 0:
					result = result+numBlock[i+1];
					break;
				case 1:
					result = result-numBlock[i+1];
					break;
				case 2:
					result = result*numBlock[i+1];
					break;
				case 3:
					result = result/numBlock[i+1];
					break;
				}
				
			}
			
			min = Integer.min(min, result);
			max = Integer.max(max, result);
			
			return;
		}
		int[] clone = nowBlock.clone();
		for(int t=0;t<4;t++) {
			if(clone[t]<=0) continue;
			choosed[choosed.length-toChoose] = t;
			clone[t]--;
			calculate(choosed, clone, toChoose-1);
			clone[t]++;
		}
	}
}
