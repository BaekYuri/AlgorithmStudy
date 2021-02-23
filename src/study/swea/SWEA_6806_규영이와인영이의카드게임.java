package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6806_규영이와인영이의카드게임 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] myCard, yourCard;
	static int myWin, yourWin;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			myCard = new int[9];
			yourCard = new int[9];
			boolean[] visited = new boolean[19];
			for (int i = 0; i < myCard.length; i++) {
				myCard[i] = Integer.parseInt(st.nextToken());
				visited[myCard[i]] = true;
			}
			for (int i = 1, a = 0; i < visited.length; i++) {
				if (visited[i])
					continue;
				yourCard[a++] = i;
			}
			myWin =0;
			yourWin =0;
			permutation(9,new boolean[9],new int[9],0,0);
			sb.append("#").append(t).append(" ").append(myWin).append(" ").append(yourWin).append("\n");

		}
		System.out.println(sb);
	}
	static void permutation(int cnt,boolean[] visited,int[] choosed,int myScore, int yourScore) {
		if(myScore>85) {

			int a = 1;
			for(int i=cnt;i>1;i--) {
				a*=i;
			}
			myWin+=a;
			return;
		}
		if(yourScore>85) {

			int a = 1;
			for(int i=cnt;i>1;i--) {
				a*=i;
			}
			yourWin+=a;
			return;
		}

		if(cnt ==0) {

			if(myScore>yourScore) {
				myWin++;
			}else if(myScore<yourScore) {
				yourWin++;
			}
			return;
			
		}
		for(int i=0;i<yourCard.length;i++) {
			if(visited[i]) continue;
			choosed[choosed.length-cnt] = yourCard[i];
			visited[i] = true;
			if(myCard[choosed.length-cnt]>choosed[choosed.length-cnt]) {
				permutation(cnt-1,visited,choosed,myScore+myCard[choosed.length-cnt]+choosed[choosed.length-cnt],yourScore);
			}else if(myCard[choosed.length-cnt]<choosed[choosed.length-cnt]) {
				permutation(cnt-1,visited,choosed,myScore,yourScore+myCard[choosed.length-cnt]+choosed[choosed.length-cnt]);
			}else {
				permutation(cnt-1,visited,choosed,myScore,yourScore);
			}

			visited[i] = false;
		}
		
	}
}
