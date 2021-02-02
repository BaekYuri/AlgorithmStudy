import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {

		int comNum = Integer.parseInt(br.readLine());
		boolean[] isVirus = new boolean[comNum + 1];

		int lineNum = Integer.parseInt(br.readLine());
		LinkedList<Integer> comLine[] = new LinkedList[comNum + 1];
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i=0;i<comLine.length;i++) {
			comLine[i] = new LinkedList<>();
		}
		StringTokenizer st;

		for (int i = 0; i < lineNum; i++) {
			String getLine = br.readLine();
			st = new StringTokenizer(getLine);

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			comLine[x].add(y);
			comLine[y].add(x);
		}
		isVirus[1] = true;
		queue.add(1);
		while (queue.size() != 0) {
			int s = queue.poll();
			Iterator<Integer> iterator = comLine[s].listIterator();

			while (iterator.hasNext()) {
				int n = iterator.next();
				if (!isVirus[n]) {
					isVirus[n] = true;
					queue.add(n);
				}
			}
		}

		int count =0;
		for(int i=2;i<isVirus.length;i++) {
			if(isVirus[i]) {
				count++;
			}
		}
		System.out.println(count);

	}
}
