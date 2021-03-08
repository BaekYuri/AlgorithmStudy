package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18233_러버덕을사랑하는모임 {
	static int N,P,E;
	static int[][] user;
	static int[] result;
	static boolean can= false;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		user = new int[N][2];
		result = new int[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			user[i][0] = Integer.parseInt(st.nextToken());
			user[i][1] = Integer.parseInt(st.nextToken());
		}
		combination(P, new int[P], 0, 0, 0);
		if(can) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<result.length;i++) {
				sb.append(result[i]).append(" ");
			}
			System.out.println(sb);
		}else {
			System.out.println(-1);
		}
	}
	static void combination(int toChoose, int[] choosed, int min, int max, int start) {
		if(can) {
			return;
		}
		if(min>E) {
			return;
		}
		if(toChoose ==0) {
//			System.out.println(Arrays.toString(choosed));
			if(max>=E) {
				can = true;
				
				
				int have = E;
				for(int i=0;i<choosed.length;i++) {
					result[choosed[i]] = user[choosed[i]][0];
					have -= user[choosed[i]][0];
				}
				
				for(int i=0;i<choosed.length;i++) {
					if(user[choosed[i]][1]-user[choosed[i]][0]>=have) {
						result[choosed[i]] += have;
						break;
					}else {
						result[choosed[i]] += user[choosed[i]][1]-user[choosed[i]][0];
						have -=user[choosed[i]][1]-user[choosed[i]][0];
					}
				
				}
			}
			return;
		}
		for(int i=start;i<N;i++) {
			choosed[choosed.length-toChoose] = i;
			combination(toChoose-1,choosed,min + user[i][0], max+user[i][1], i+1);
		}
	}
}
