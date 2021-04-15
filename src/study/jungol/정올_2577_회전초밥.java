package study.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 정올_2577_회전초밥 {
	static int N,D,K,C;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N =Integer.parseInt(st.nextToken());//접시의 수
		D =Integer.parseInt(st.nextToken());//초밥의 가짓수
		K =Integer.parseInt(st.nextToken());//연속해서 먹는 접시의 수
		C =Integer.parseInt(st.nextToken());//쿠폰번호
		
		int[] sushi = new int[N];
		for(int i=0;i<N;i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		HashSet<Integer> set = new HashSet<>();
		int[] count = new int[D+1];
		for(int i=0;i<K;i++) {
			count[sushi[i]]++;
			set.add(sushi[i]);
		}
		int max = set.size();
		if(count[C]==0) max++;
		for(int i=1;i<N;i++) {
			int poll = sushi[i-1];
			count[poll]--;
			if(count[poll]==0) set.remove(poll);
			
			set.add(sushi[(i+K-1)%N]);
			count[sushi[(i+K-1)%N]]++;
			int temp = set.size();
			if(temp<max-1) continue;
			if(count[C]==0) temp++;
			max = Math.max(max, temp);
		}
		System.out.println(max);
	}
}
