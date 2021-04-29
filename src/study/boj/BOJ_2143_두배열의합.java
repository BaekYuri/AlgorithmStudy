package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2143_두배열의합 {
	static int T, N, M;
	static int[] A, B;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();

		List<Point> listA = new ArrayList<>();
		List<Point> listB = new ArrayList<>();
		List<Point> listC = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			
			for (int j = 0, size = listA.size(); j < size; j++) {
				Point temp = listA.get(j);

				int tofind = temp.getNow() + A[i];
				int idx = listA.indexOf(new Point(tofind, 0));
				if (idx != -1) {
					Point found = listA.get(idx);
					found.setCount(found.getCount() + 1);
				} else {
					listA.add(new Point(tofind, 1));
				}
			}
			if(listA.indexOf(new Point(A[i],0))==-1) {
				listA.add(new Point(A[i], 1));
			}
		}
		for (int i = 0; i < M; i++) {

			for (int j = 0, size = listB.size(); j < size; j++) {
				Point temp = listB.get(j);

				int tofind = temp.getNow() + B[i];
				int idx = listB.indexOf(new Point(tofind, 0));
				if (idx != -1) {
					Point found = listB.get(idx);
					found.setCount(found.getCount() + 1);
				} else {
					listB.add(new Point(tofind, 1));
				}
			}
			if(listB.indexOf(new Point(B[i],0))==-1) {
				listB.add(new Point(B[i], 1));
			}
		}

		for (int i = 0, sizeA=listA.size(); i < sizeA; i++) {
			Point aPoint = listA.get(i);
			for (int j = 0, sizeB = listB.size(); j < sizeB; j++) {
				Point temp = listB.get(j);

				int tofind = temp.getNow() + aPoint.getNow();
				int idx = listC.indexOf(new Point(tofind, 0));
				if (idx != -1) {
					Point found = listC.get(idx);
					found.setCount(found.getCount() + (aPoint.getCount()*temp.getCount()));
				} else {
					listC.add(new Point(tofind, (aPoint.getCount()*temp.getCount())));
				}
			}
		}
		System.out.println(listC.get(listC.indexOf(new Point(T, 0))).getCount());
	}

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());

		B = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
	}

	static class Point {
		int now, count;

		public int getNow() {
			return now;
		}

		public void setNow(int now) {
			this.now = now;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public Point(int now, int count) {
			super();
			this.now = now;
			this.count = count;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + now;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (now != other.now)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Point [now=" + now + ", count=" + count + "]";
		}

	}
}
