package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2564_경비원_210413 {
	static int[][] shop;
	static int[] donggun;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());

		int shopNum = Integer.parseInt(br.readLine());
		shop = new int[shopNum][];
		donggun = new int[2];
		for (int i = 0; i < shopNum + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int place = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());
			if (i == shopNum) {
				donggun = new int[]{place,point};
			} else {
				shop[i] = new int[]{place,point};
			}
		}
		int result = 0;
		for(int i=0;i<shopNum;i++) {
			result+=getDistance(shop[i]);
		}
		System.out.println(result);
	}


	static int getDistance(int[] shopPlace) {
		int result = 0;
		switch(donggun[0]) {
		case 1:
			if(shopPlace[0]==3) {
				result = shopPlace[1]+donggun[1];
			}else if(shopPlace[0]==4){
				result = shopPlace[1]+N-donggun[1];
			}else if(shopPlace[0]==donggun[0]) {
				result = Math.abs(shopPlace[1]-donggun[1]);
			}else {
				result = Math.min(M+shopPlace[1]+donggun[1],M+2*N-shopPlace[1]-donggun[1]);
			}
			break;
		case 2:
			if(shopPlace[0]==3) {
				result = M-shopPlace[1]+donggun[1];
			}else if(shopPlace[0]==4){
				result = M-shopPlace[1]+N-donggun[1];
			}else if(shopPlace[0]==donggun[0]) {
				result = Math.abs(shopPlace[1]-donggun[1]);
			}else {
				result = Math.min(M+shopPlace[1]+donggun[1],M+2*N-shopPlace[1]-donggun[1]);
			}
			break;
		case 3:
			if(shopPlace[0]==1) {
				result = shopPlace[1]+donggun[1];
			}else if(shopPlace[0]==2){
				result = shopPlace[1]+M-donggun[1];
			}else if(shopPlace[0]==donggun[0]) {
				result = Math.abs(shopPlace[1]-donggun[1]);
			}else {
				result = Math.min(N+shopPlace[1]+donggun[1],N+2*M-shopPlace[1]-donggun[1]);
			}
			break;
		case 4:
			if(shopPlace[0]==1) {
				result = N-shopPlace[1]+donggun[1];
			}else if(shopPlace[0]==2){
				result = N-shopPlace[1]+M-donggun[1];
			}else if(shopPlace[0]==donggun[0]) {
				result = Math.abs(shopPlace[1]-donggun[1]);
			}else {
				result = Math.min(N+shopPlace[1]+donggun[1],N+2*M-shopPlace[1]-donggun[1]);
			}
			break;
		}
		// 1은 블록의 북쪽, 2는 블록의 남쪽, 3은 블록의 서쪽, 4는 블록의 동쪽에 상점이 있음을 의미한다.
		return result;
	}
}
