package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1477_휴게소세우기 {
	static int N, M, L;
	static List<Integer> shop;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		shop = new ArrayList<Integer>();
		
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			shop.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(shop);
		
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)-> {return Integer.compare(o2[0], o1[0]);});
		
		queue.add(new int[] {shop.get(0),0,shop.get(0),1});
		for(int i=1;i<N;i++) {
			int first = shop.get(i-1);
			int second = shop.get(i);
			queue.add(new int[] {second-first,first, second,1});
		}
		queue.add(new int[] {L-shop.get(N-1),shop.get(N-1),L,1});
		
	
		int[] now = queue.poll();
		for(int j=0;j<M;j++) {
			//배열 = {거리/등분, start, end, 등분한갯수}
			int temp = (now[2]-now[1])/(now[3]+1);
			if((now[2]-now[1])%(now[3]+1)!=0) temp++;
			queue.add(new int[] {temp,now[1],now[2],now[3]+1});
			
			now = queue.poll();
		}
		
		System.out.println(now[0]);
	}
}
