package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1167_트리의지름 {
	static int N;
	static ArrayList<int[]> list[];
	static int result=0;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<>();
		}

		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			String to = "";
			while((to=st.nextToken())!=null) {
				if(to.equals("-1")) break;
				list[from].add(new int[] {Integer.parseInt(to),Integer.parseInt(st.nextToken())});
			}
			
		}
		visited[1] = true;
		dfs2(1,0);
		System.out.println(result);
		return;
	}

	static int dfs2(int start, int depth) {
		if(list[start].isEmpty()) return depth;
		int[] max = new int[list[start].size()];
		Arrays.fill(max, depth);
		for(int i=0;i<list[start].size();i++) {
			int[] temp = list[start].get(i);
			if(!visited[temp[0]]) {
				visited[temp[0]] = true;
				max[i] = Math.max(dfs2(temp[0],depth+temp[1]),max[i]);
			}
		}
		if(max.length==1) {
			result = Math.max(result, max[0]-depth);
			return max[0];
		}
		Arrays.sort(max);
		result = Math.max(result, max[max.length-1]+max[max.length-2]-(2*depth));
		return max[max.length-1];
	}
}
