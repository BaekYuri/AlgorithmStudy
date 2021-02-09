

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스문제_리스트 {
	public static void main(String[] args) throws IOException {
		List<Integer> list = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] result = new int[N];
		for(int n=1;n<=N;n++) {
			list.add(n);
		}
		
		
		int now =K-1;
		int i=0;
		while(!list.isEmpty()) {
			if(list.size()<=now) {
				now = now%list.size();
			}
			result[i++] = list.remove(now);
			now+=K-1;
			
		}
		
		String resStr = Arrays.toString(result);
		resStr = resStr.replace('[', '<');
		resStr = resStr.replace(']', '>');
		
		System.out.println(resStr);
	}
}
