package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238_Contact {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = 1;
		String s;
		StringBuilder sb = new StringBuilder();
		while ((s = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s);

			int length = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			LinkedList<Integer> link[] = new LinkedList[101];
			for (int t = 1; t <= 100; t++) {
				link[t] = new LinkedList<>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < length / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if (!link[from].contains(to)) {
					link[from].add(to);
				}
			}
			int[] level = new int[101];
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[]{start, 1});
			int highlevel = 0;
			while(!queue.isEmpty()) {
				int[] temp = queue.poll();
				if(level[temp[0]]!=0) continue;
				level[temp[0]] = temp[1];
				highlevel = Integer.max(highlevel, temp[1]);
				for(int t=0;t<link[temp[0]].size();t++) {
					int next = link[temp[0]].get(t);
					queue.add(new int[] {next, temp[1]+1});
				}
			}
			int result = 0;
			for(int i=1;i<=100;i++) {
				if(level[i]==highlevel) {
					result = i;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");

			tc++;
		}
		System.out.println(sb);
	}
}
