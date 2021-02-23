package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2477_참외밭 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		

		int[][] input = new int[6][2];
		for(int i=0;i<6;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			
			input[i][0] = direction;
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		for(int i=0;i<6;i++) {
			result += input[i][1]* input[(i+1)%6][1];
		}
		Arrays.sort(input, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[0]-o2[0];
			}
		});
		int bigW = Integer.MIN_VALUE;
		for(int i=0;i<3;i++) {
			bigW = Integer.max(bigW, input[i][1]);
		}
		int bigH = Integer.MIN_VALUE;
		for(int i=3;i<6;i++) {
			bigH = Integer.max(bigH, input[i][1]);
		}
		result-= bigW*bigH*2;
		
		System.out.println(result*N);
	}
}
