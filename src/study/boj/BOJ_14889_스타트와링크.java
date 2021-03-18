package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {
	static int N;
	static int[][] synergy;
	static int minDistance=Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		
		synergy = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				synergy[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(N/2, 0, 0);
		System.out.println(minDistance);
	}
	static void combination(int toChoose, int choosed, int start) {
		
		if(toChoose ==0) {
			
			if(choosed>0) {
				int[] teamA =new int[N/2];
				int[] teamB =new int[N/2];
				for(int i=0,a=0,b=0;i<N;i++) {
					if((choosed & (1<<i))!=0) {
						teamA[a++] = i;
					}else {
						teamB[b++] = i;
					}
				}
				minDistance= Integer.min(minDistance, Math.abs(getStat(teamA)-getStat(teamB)));
			}
			return;
		}
		for(int i=start; i<N;i++) {
			combination(toChoose-1, choosed | (1<<i-1), i+1);
		}
	}
	static int getStat(int[] a) {
		int stat = 0;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				stat +=synergy[a[i]][a[j]];
			}
		}
		return stat;
	}
}
