package study.boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//0,000,000,000
public class BOJ_2529_부등호 {
	static int K;
	static String input;
	static long min= Long.MAX_VALUE;
	static long max= Long.MIN_VALUE;
	static String resultMin, resultMax;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		input = br.readLine();
		input = input.replace(" ", "");
		permutation(K+1, new boolean[10], new int[K+1]);
		
		StringBuilder sb= new StringBuilder();
		sb.append(resultMax).append("\n").append(resultMin);
		System.out.println(sb);
		
	}
	static void permutation(int toChoose, boolean[] visited, int[] choosed) {
		if(toChoose ==0) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<choosed.length-1;i++) {
				switch(input.charAt(i)) {
				case '<':
					if(choosed[i] >= choosed[i+1]) {
						return;
					}else {
						sb.append(choosed[i]);
					}
					break;
				case '>':
					if(choosed[i]<=choosed[i+1]) {
						
						return;
					}else {
						sb.append(choosed[i]);
					}
					break;
				}
			}
			sb.append(choosed[choosed.length-1]);
			long temp = Long.parseLong(sb.toString());
			if(temp<min) {
				min = Long.min(min, temp);
				resultMin = sb.toString();
			}
			if(temp>max) {
				max = Long.max(max, temp);
				resultMax = sb.toString();
			}
			
			return;
			
		}
		for(int i=0;i<=9;i++) {
			if(visited[i]) continue;
			choosed[choosed.length-toChoose] = i;
			visited[i] = true;
			permutation(toChoose-1,visited,choosed);
			visited[i] = false;
		}
	}
}
