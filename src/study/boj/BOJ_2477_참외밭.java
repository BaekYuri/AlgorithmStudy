package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2477_참외밭 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[] directionCnt = new int[5];
		int[][] input = new int[6][2];
		for(int i=0;i<6;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			directionCnt[direction]++;
			input[i][0] = direction;
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		int result =1;
		int[] big = new int[2];
		for(int i=1, a=0;i<=4;i++) {
			if(directionCnt[i]==1) {
				for(int j=0;j<6;j++) {
					if(input[j][0]==i) {
						big[a++] = j;
						result *=input[j][1];
						break;
					}
				}
				
			}
		}
		Arrays.sort(big);
		if(big[0] == big[1]-1) {
			result = result - (input[(big[1]+2)%6][1])*(input[(big[1]+3)%6][1]);
		}else {
			result = result - (input[(big[0]+2)%6][1])*(input[(big[0]+2)%6][1]);
		}
		
		System.out.println(result*N);
	}
}
