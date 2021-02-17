package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1992_쿼드트리 {
	static int N;
	static char[][] movie;
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		movie = new char[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				movie[i][j] = s.charAt(j);
			}
		}
		int now = N / 2;
		
		getTree(now, movie.clone());
		
		System.out.println(result);
	}

	static void getTree(int now, char[][] nowArray) {
		int cnt=0;
		char first[] = new char[4];
		first[0] = nowArray[0][0];
		if(now ==0) {
			result.append(first[0]);
			return;
		}
		result.append("(");
		char[][] whiteOrBlack = new char[now][now];
		for (int i = 0; i < now; i++) {
			Arrays.fill(whiteOrBlack[i], first[0]);
		}
		char[][] subArray = new char[now][now];
		for (int i = 0; i < now; i++) {
			subArray[i] = Arrays.copyOf(nowArray[i], now);
		}
		if(Arrays.deepEquals(whiteOrBlack, subArray)) {
			result.append(first[0]);
			cnt++;
		}else {
			getTree(now / 2, subArray);
		}
		
		
		first[1] = nowArray[0][now];
		if(first[0]!=first[1]) {
			whiteOrBlack = new char[now][now];
			for (int i = 0; i < now; i++) {
				Arrays.fill(whiteOrBlack[i], first[1]);
			}
		}
		
		
		for (int i = 0; i < now; i++) {
			subArray[i] = Arrays.copyOfRange(nowArray[i], now, now * 2);
		}
		if(Arrays.deepEquals(whiteOrBlack, subArray)) {
			result.append(first[1]);
			cnt++;
		}else {
			getTree(now / 2, subArray);
		}
		
		first[2] = nowArray[now][0];
		if(first[1]!=first[2]) {
			whiteOrBlack = new char[now][now];
			for (int i = 0; i < now; i++) {
				Arrays.fill(whiteOrBlack[i], first[2]);
			}
		}
		for (int i = 0; i < now; i++) {
			subArray[i] = Arrays.copyOfRange(nowArray[i + now], 0, now);
		}
		if(Arrays.deepEquals(whiteOrBlack, subArray)) {
			result.append(first[2]);
			cnt++;
		}else {
			getTree(now / 2, subArray);
		}

		first[3] = nowArray[now][now];
		if(first[2]!=first[3]) {
			whiteOrBlack = new char[now][now];
			for (int i = 0; i < now; i++) {
				Arrays.fill(whiteOrBlack[i], first[3]);
			}
		}
		for (int i = 0; i < now; i++) {
			subArray[i] = Arrays.copyOfRange(nowArray[i + now], now, now * 2);
		}
		
		if(Arrays.deepEquals(whiteOrBlack, subArray)) {
			result.append(first[3]);
			cnt++;
		}else {
			getTree(now / 2, subArray);
		}

		if(cnt ==4 && first[0]==first[1]&& first[0]==first[2]&& first[0]==first[3]) {
			result.delete(result.length()-5, result.length());
			result.append(first[0]);
		}else {
			result.append(")");
		}
		
	}
}
