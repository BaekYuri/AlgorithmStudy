package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1485_정사각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int[][] point = new int[4][2];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				point[i][0] = Integer.parseInt(st.nextToken());
				point[i][1] = Integer.parseInt(st.nextToken());

			}
			int a = point[0][0];
			int b = point[0][1];

			Arrays.sort(point, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					int distance1 = Math.abs(o1[0] - a)*Math.abs(o1[0] - a) + Math.abs(o1[1] - b)*Math.abs(o1[1] - b);
					int distance2 = Math.abs(o2[0] - a)*Math.abs(o2[0] - a) + Math.abs(o2[1] - b)*Math.abs(o2[1] - b);
					return distance1 - distance2;
				}
			});
			
			
			int distance = Math.abs(point[1][0] - a)*Math.abs(point[1][0] - a) + Math.abs(point[1][1] - b)*Math.abs(point[1][1] - b);
			boolean isSquare = true;

			int tempDistance = Math.abs(point[2][0] - a)*Math.abs(point[2][0] - a) + Math.abs(point[2][1] - b)*Math.abs(point[2][1] - b);
			if (distance != tempDistance)
				isSquare = false;

			tempDistance = Math.abs(point[2][0] - point[3][0])*Math.abs(point[2][0] - point[3][0]) + Math.abs(point[2][1] - point[3][1])* Math.abs(point[2][1] - point[3][1]);
			if (distance != tempDistance)
				isSquare = false;
			
			tempDistance = Math.abs(point[1][0] - point[3][0])*Math.abs(point[1][0] - point[3][0]) + Math.abs(point[1][1] - point[3][1])* Math.abs(point[1][1] - point[3][1]);
			if (distance != tempDistance)
				isSquare = false;

			if (isSquare) {
				int s1 = Math.abs(point[0][0] - point[3][0])* Math.abs(point[0][0] - point[3][0]) + Math.abs(point[0][1] - point[3][1])*Math.abs(point[0][1] - point[3][1]);
				int s2 = Math.abs(point[1][0] - point[2][0])*Math.abs(point[1][0] - point[2][0]) + Math.abs(point[1][1] - point[2][1])*Math.abs(point[1][1] - point[2][1]);

				if (s1 != s2) {
					isSquare = false;
				}
			}

			if (isSquare) {
				sb.append(1).append("\n");
			} else {

				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}
}
