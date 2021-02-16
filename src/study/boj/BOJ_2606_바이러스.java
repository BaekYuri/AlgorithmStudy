package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
//BFS
public class BOJ_2606_바이러스 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {

		int comNum = Integer.parseInt(br.readLine());
		boolean[] isVirus = new boolean[comNum + 1];

		int lineNum = Integer.parseInt(br.readLine());
		LinkedList<Integer> comLine[] = new LinkedList[comNum + 1];
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i=0;i<comLine.length;i++) {//comLine 객체 생성
			comLine[i] = new LinkedList<>();
		}
		StringTokenizer st;

		for (int i = 0; i < lineNum; i++) {//양방향이니까 두곳에다가 연결된 인덱스 추가
			String getLine = br.readLine();
			st = new StringTokenizer(getLine);

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			comLine[x].add(y);
			comLine[y].add(x);
		}
		isVirus[1] = true;
		queue.add(1);//1부터 감염 시작하므로 초기값 1 시작
		while (queue.size() != 0) {
			int s = queue.poll();
			Iterator<Integer> iterator = comLine[s].listIterator(); //다음에 연결된 컴퓨터 리스트

			while (iterator.hasNext()) {//바이러스 있게 만들기
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
