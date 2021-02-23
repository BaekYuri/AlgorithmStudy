package study.swea;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208_Flatten {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
	static int maxValue, minValue;
	static int[] col = new int[100];
	static int dump;
	
	
	static void getCol() throws IOException {
		
		String cols = br.readLine();
		StringTokenizer st = new StringTokenizer(cols);
		int i=0;
		int temp;
		while(st.hasMoreTokens()) {
			temp = Integer.parseInt(st.nextToken());
			col[i]=temp;
			i++;
		}
		
		
	}
	
	static void getMax() {
		max=Integer.MIN_VALUE;
		for(int i=0;i<col.length;i++) {
			if(max<col[i]) {
				max = col[i];
				maxValue = i;
			}
		}
	}
	static void getMin() {
		min=Integer.MAX_VALUE;
		for(int i=0;i<col.length;i++) {
			if(min>col[i]) {
				min = Integer.min(min, col[i]);
				minValue = i;
			}
		}
	}
	static int doDump(int d) {
		getMax();
		getMin();
		if(d<1) return max-min;
		
		if(max-min<=1) {
			return max-min;
		}
		
		
		col[maxValue] = --max;
		col[minValue] = ++min;

		return doDump(d-1);
	}
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=10;t++) {
			
			dump = Integer.parseInt(br.readLine());
			
			getCol();
			
			int result = doDump(dump);
			
			sb.append("#").append(t).append(" ").append(result);
			
		}
		System.out.println(sb);
	}
}
