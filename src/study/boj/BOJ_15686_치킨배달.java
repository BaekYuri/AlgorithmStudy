package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {
	static int N, M;
	static int[][] city;
	static List<int[]> restorant, house;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		restorant = new ArrayList<>();
		house = new ArrayList<>();
		city = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				switch (city[i][j]) {
				case 1:
					house.add(new int[] { i, j });
					break;
				case 2:
					restorant.add(new int[] { i, j });
					break;
				}
			}
		}
		
	
//		combination(M,new int[M][2],0,);
		
		powerset(new boolean[restorant.size()],M, 0, restorant.size());
		System.out.println(min);
	}
	static void powerset(boolean[] choosed, int max, int choosedCnt, int toChoose) {
		if(toChoose == 0 || choosedCnt == max) {
			if(choosedCnt!=0) {
				int[] now = new int[house.size()];
				Arrays.fill(now, Integer.MAX_VALUE);
				for(int i=0;i<choosed.length;i++) {
					if(choosed[i]) {
						int[] tem = restorant.get(i);
						for(int j=0;j<house.size();j++) {
							int[] temp = house.get(j);
							int distance = Math.abs(temp[0]-tem[0])+Math.abs(temp[1]-tem[1]);
							now[j] = Integer.min(now[j], distance);
						}
					}
				}
				int sum = 0;
				for(int i=0;i<now.length;i++) {
					sum+=now[i];
				}	
				min=Integer.min(min,sum);
			}
			return;
		}
		choosed[choosed.length-toChoose] = true;
		powerset(choosed, max, choosedCnt+1,toChoose-1);
		choosed[choosed.length-toChoose] = false;
		powerset(choosed, max, choosedCnt,toChoose-1);
		
	}
	
}

	

