package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578_빙고 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] myBingo = new int[5][5];
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				myBingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] count = new int[3][5];
		
		int result = 0;
		
		int nowBingo =0;
		

		outer : for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				int say = Integer.parseInt(st.nextToken());
				result++;
				for(int a=0;a<5;a++) {
					for(int b=0;b<5;b++) {
						if(myBingo[a][b] != say) continue;
						
						if(a==b) {
							if(++count[2][0]==5) {
								nowBingo++;
							}
													
						}
						if(a+b==4) {
							if(++count[2][1]==5) {
								nowBingo++;
							}
						}
						if(++count[0][a]==5) {
							nowBingo++;
						}

						if(++count[1][b]==5) {
							nowBingo++;
						}
						
						if(nowBingo>=3) {
							break outer;
						}
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
