package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2469_사다리타기 {
	static int N, M, lineNum;
	static char[][] sadari;
	static char[] resultAlpa;
	static int[] nowAlpa;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		M = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		
		resultAlpa = br.readLine().toCharArray();
		nowAlpa = new int[M];
		for(int i=0;i<M;i++) {
			nowAlpa[i] = i;
		}
		
		sadari = new char[N][];
		for(int i=0;i<N;i++) {
			sadari[i] = br.readLine().toCharArray();
			if(sadari[i][0]=='?') lineNum = i;
		}
		int[] temp = nowAlpa.clone();
		nowAlpa = gotoSadari(0, lineNum-1, nowAlpa.clone());
		temp = gotoSadari(lineNum+1, N-1, temp.clone());
		
		StringBuilder sb = new StringBuilder();

		System.out.println(sb);
	}
	
	
	static int[] gotoSadari(int start, int end, int[] now) {
		for(int j=start;j<=end;j++) {
			for(int i=0;i<M;i++) {
				boolean moved = false;
				if(now[i]>0) {
					if(sadari[j][now[i]-1]=='-') {
						now[i]--;
						moved = true;
					}
				}
				if(now[i]<M-1 && !moved) {
					if(sadari[j][now[i]]=='-') {
						now[i]++;
					}
				}
				
			}
		}
		
		return now;
	}
}
