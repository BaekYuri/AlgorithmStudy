package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_12783_곱셈게임 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			List<Integer> list = new ArrayList<>();
			for(int i=0;i<N;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int M = Integer.parseInt(br.readLine());
			
			int max =0;
			int toGet[] = new int[M];
			for(int i=0;i<M;i++) {
				toGet[i] = Integer.parseInt(br.readLine());
				max = Math.max(max, toGet[i]);
			}
			int[] dp = new int[max+1];
			for(int j=0;j<=max;j++) {
				String s= Integer.toString(j);
				int length = s.length();
				if(length==1) {
					if(!list.contains(s.charAt(0)-'0')) {
						dp[j]=-1;
					}
				}else {
					int tmp  = dp[j%((int)Math.pow(10, length-1))];
					if(tmp==-1 || (tmp==0&&!list.contains(s.charAt(0)-'0'))) {
						dp[j]=-1;
					}
				}
			}
			
			for(int i=0;i<=max;i++) {
				if(dp[i]==-1) continue;
				for(int j=0, size = list.size();j<size;j++) {
					int temp = i*list.get(j);
					if(temp<=max) {
						if(dp[temp]==-1) {
							dp[temp] = dp[i]+1;
						}else {
							dp[temp] = Integer.min(dp[temp], dp[i]+1);
						}
					}
				}
			}
			
			for(int i=0;i<M;i++) {
				sb.append(dp[toGet[i]]).append("\n");
			}
			
		}
		System.out.println(sb);
	}
}
