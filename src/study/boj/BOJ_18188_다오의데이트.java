package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18188_다오의데이트 {
	static char[][] map;
	static int N,M, maxMove;
	static char[][] marid;
	static int[] dizini, dao;
	static boolean result = false;
	static char[] resultArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		dizini = new int[2];
		dao = new int[2];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='D') {
					dao[0] = i;
					dao[1] = j;
				}else if(map[i][j]=='Z') {
					dizini[0] = i;
					dizini[1] = j;
				}
			}
		}
		
		maxMove = Integer.parseInt(br.readLine());
		marid = new char[maxMove][2];
		for(int i=0;i<maxMove;i++) {
			st = new StringTokenizer(br.readLine());
			marid[i][0] = st.nextToken().charAt(0);
			marid[i][1] = st.nextToken().charAt(0);
		}
		permutation(maxMove, new char[maxMove]);
		
		if(result) {
			StringBuilder sb= new StringBuilder();
			sb.append("YES\n");
			for(char a:resultArr) {
				sb.append(a);
			}
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
	}
	static void permutation(int toChoose, char[] choosed) {
		if(result) return;
		if(toChoose ==0) {
//			System.out.println(Arrays.toString(choosed));
			int[] nowDao = dao.clone();
			char[][] clone = new char[N][];
			for(int t=0;t<N;t++) {
				clone[t] = map[t].clone();
			}
			for(int i=0;i<choosed.length;i++) {
				int ni=0, nj=0;
				switch (choosed[i]) {
				case 'W':
					ni = nowDao[0] - 1;
					nj = nowDao[1];
					break;
				case 'A':
					ni = nowDao[0];
					nj = nowDao[1]-1;
					break;
				case 'D':
					ni = nowDao[0];
					nj = nowDao[1]+1;
					break;
				case 'S':
					ni = nowDao[0]+1;
					nj = nowDao[1];
					break;
				}
				if(ni>=0 && ni<N && nj>=0 && nj<M) {
					if(clone[ni][nj]=='Z') {
						result = true;
						resultArr = Arrays.copyOf(choosed, i+1);
						break;
					}else if(clone[ni][nj]=='@') {
						break;
					}else if(clone[ni][nj]=='.') {
						clone[nowDao[0]][nowDao[1]]='.';
						clone[ni][nj]='D';
						nowDao[0] = ni;
						nowDao[1] = nj;
					}
				}else {
					break;
				}
			}
			
			return;
		}
		for(int i=0;i<2;i++) {
			choosed[choosed.length-toChoose]= marid[choosed.length-toChoose][i];
			permutation(toChoose-1,choosed);
		}
	}
}
