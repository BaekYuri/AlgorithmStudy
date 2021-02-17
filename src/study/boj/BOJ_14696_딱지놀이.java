package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14696_딱지놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			int[] aCard = new int[5];
			int[] bCard = new int[5];
			char winner ='D';
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			while(st.hasMoreTokens()) {
				int temp = Integer.parseInt(st.nextToken());
				switch(temp) {
				case 1:
					aCard[1]++;
					break;
				case 2:
					aCard[2]++;
					break;
				case 3:
					aCard[3]++;
					break;
				case 4:
					aCard[4]++;
					break;
				}
			}
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			while(st.hasMoreTokens()) {
				int temp = Integer.parseInt(st.nextToken());
				switch(temp) {
				case 1://세모
					bCard[1]++;
					break;
				case 2://네모
					bCard[2]++;
					break;
				case 3://동그라미
					bCard[3]++;
					break;
				case 4://별
					bCard[4]++;
					break;
				}
			}
			for(int a=4;a>0;a--) {
				if(aCard[a]!=bCard[a]) {
					if(aCard[a]>bCard[a]) {
						winner = 'A';
					}else {
						winner = 'B';
					}
					break;
				}
			}
			
			
			sb.append(winner).append("\n");
		}
		System.out.println(sb);
	}
}
