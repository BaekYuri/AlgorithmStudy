

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966_프린터큐 {
	static Queue<Doc> queue;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			queue = new LinkedList<Doc>();
			s = br.readLine();
			st = new StringTokenizer(s);
			for (int n = 0; n < N; n++) {
				int temp = Integer.parseInt(st.nextToken());
				Doc tempDoc = new Doc(n, temp);
				queue.add(tempDoc);
			}
	
			
			Queue<Doc> result = new LinkedList<>();
			while (!queue.isEmpty()) {
				Doc tempDocs = queue.poll();
				Iterator<Doc> it = queue.iterator();
				boolean isHave = false;
				while (it.hasNext()) {
					if (tempDocs.priority < it.next().priority) {
						queue.add(tempDocs);
						isHave = true;
						break;
					}
				}
				if (!isHave) {
					result.add(tempDocs);
				}
				
			}
			Iterator<Doc> iter = result.iterator();
			int count =0;
			while(iter.hasNext()) {
				count++;
				if(iter.next().number == M) {
					break;
				}
			}
			System.out.println(count);
		}
	}

	static class Doc {
		int number;
		int priority;

		public Doc(int number, int priorty) {
			this.number = number;
			this.priority = priorty;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return number+" "+priority;
		}
	}
}
