package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬디펜스 {
	static int N, M, D;
	static int[][] map;
	static List<int[]> enemyPoint;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		enemyPoint = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					enemyPoint.add(new int[] { i, j });
				}
			}
		}
		
		combination(3,new int[3],0);
		System.out.println(max);
	}

	static void combination(int toChoose, int[] choosed, int startIdx) {
		if (toChoose == 0) {
			
			int cnt = find(choosed);
			max = Integer.max(max, cnt);
			return;
		}
		for (int i = startIdx; i < M; i++) {
			choosed[choosed.length - toChoose] = i;
			combination(toChoose - 1, choosed, i + 1);
		}
	}

	static int find(int[] hunterLocation) {
		int count = 0;
		int nowX[] = new int[3];
		int nowY[] = new int[3];
		Arrays.fill(nowX, -1);
		Arrays.fill(nowY, -1);
		List<int[]> list = new ArrayList<>();
		for(int[] a : enemyPoint) {
			list.add(a.clone());
		}


		while (!list.isEmpty()) {
			for (int i = 0; i < 3; i++) {
				int nN = N;
				int nM = hunterLocation[i];
				int minDist = Integer.MAX_VALUE;

				for (int j = 0; j < list.size(); j++) {
					int tempDist = Math.abs(nN - list.get(j)[0]) + Math.abs(nM - list.get(j)[1]);
					if (tempDist > D)
						continue;
					if (tempDist < minDist) {
						minDist = Integer.min(minDist, tempDist);
						nowX[i] = list.get(j)[0];
						nowY[i] = list.get(j)[1];
					} else if (tempDist == minDist) {
						if (nowY[i] > list.get(j)[1]) {
							nowX[i] = list.get(j)[0];
							nowY[i] = list.get(j)[1];
						}
					}
				}
			} // 궁수가 공격하는 적의 좌표를 다 구했다

			for(int i=0;i<3;i++) {
				int temp[] = new int[2];
				temp[0] = nowX[i];
				temp[1] = nowY[i];
				if(temp[0] ==-1 && temp[1] == -1) continue;
				for(int j = 0; j<list.size();j++) {
					if(list.get(j)[0] == temp[0] && list.get(j)[1] == temp[1]) {
						list.remove(j);
						count++;
						break;
					}
				}
			}

			for (int i = 0; i < list.size(); i++) {
				int[] temp = list.get(i);
				temp[0]++;
				if (temp[0] >= N) {
					list.remove(i--);
				}
			}

		}
		return count;
	}
}
