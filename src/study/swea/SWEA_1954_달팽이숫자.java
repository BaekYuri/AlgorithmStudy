package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SWEA_1954_달팽이숫자 {
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[][] snail;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int size = Integer.parseInt(br.readLine());
			snail = new int[size][size];
			int now[] = new int[2];
			now[0] = 0;
			now[1] = 0;
			int nowDeltas = 0;
			for (int i = 1; i <= size * size; i++) {
				snail[now[0]][now[1]] = i;
				
				now[0] += deltas[nowDeltas][0];
				now[1] += deltas[nowDeltas][1];
				
				if (now[0] < 0 || now[0] >= size ||now[1] < 0 || now[1] >= size ||snail[now[0]][now[1]] != 0) {
					now[0] -= deltas[nowDeltas][0];
					now[1] -= deltas[nowDeltas][1];
					nowDeltas++;
					if (nowDeltas == 4) {
						nowDeltas = 0;
					}
					
					now[0] += deltas[nowDeltas][0];
					now[1] += deltas[nowDeltas][1];
					
				} 
			}
			sb.append("#").append(t).append("\n");
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++) {
					sb.append(snail[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);
	}

}
