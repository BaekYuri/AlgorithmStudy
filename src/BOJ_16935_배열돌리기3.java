import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935_배열돌리기3 {
	static int[][] array;
	static int N, M, R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		array = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int r = 0; r < R; r++) {
			int order = Integer.parseInt(st.nextToken());
			switch (order) {
			case 1:
				calc1();
				break;
			case 2:
				calc2();
				break;
			case 3:
				calc3();
				break;
			case 4:
				calc4();
				break;
			case 5:
				calc5();
				break;
			case 6:
				calc6();
				break;
			}
		}

		for (int[] row : array) {
			for (int v : row) {
				sb.append(v).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void calc6() {//반시계방향으로 바꾸는 함수
		int[][] tempArray = new int[array.length / 2][array[0].length / 2]; //임시배열 생성
		for (int i = 0; i < tempArray.length; i++) {//1번 그룹 저장
			for (int j = 0; j < tempArray[0].length; j++) {
				tempArray[i][j] = array[i][j];
			}
		}
		for (int i = 0; i < tempArray.length; i++) {
			for (int j = tempArray[0].length; j < array[0].length; j++) {//2번->1번
				array[i][j - tempArray[0].length] = array[i][j];
			}
		}
		for (int i = tempArray.length; i < array.length; i++) {//3번->2번
			for (int j = tempArray[0].length; j < array[0].length; j++) {
				array[i - tempArray.length][j] = array[i][j];
			}
		}
		for (int i = tempArray.length; i < array.length; i++) {//4번->3번
			for (int j = 0; j < tempArray[0].length; j++) {
				array[i][j + tempArray[0].length] = array[i][j];
			}
		}
		for (int i = 0; i < tempArray.length; i++) {//1번(임시)->4번
			for (int j = 0; j < tempArray[0].length; j++) {
				array[i + tempArray.length][j] = tempArray[i][j];
			}
		}

	}

	private static void calc5() {//시계방향으로 바꾸는 함수
		int[][] tempArray = new int[array.length / 2][array[0].length / 2];//임시배열 생성
		for (int i = 0; i < tempArray.length; i++) {
			for (int j = 0; j < tempArray[0].length; j++) {
				tempArray[i][j] = array[i][j];
			}
		}
		for (int i = tempArray.length; i < array.length; i++) {//4번->1번
			for (int j = 0; j < tempArray[0].length; j++) {
				array[i - tempArray.length][j] = array[i][j];
			}
		}
		for (int i = tempArray.length; i < array.length; i++) {//3번->4번
			for (int j = tempArray[0].length; j < array[0].length; j++) {
				array[i][j - tempArray[0].length] = array[i][j];
			}
		}
		for (int i = 0; i < tempArray.length; i++) {//2번->3번
			for (int j = tempArray[0].length; j < array[0].length; j++) {
				array[i + tempArray.length][j] = array[i][j];
			}
		}
		for (int i = 0; i < tempArray.length; i++) {//1번(임시)->2번
			for (int j = 0; j < tempArray[0].length; j++) {
				array[i][j + tempArray[0].length] = tempArray[i][j];
			}
		}

	}

	private static void calc3() {//오른쪽으로 90도 바꾸기
		int[][] turned = new int[array[0].length][array.length]; //가로세로가 반대인 배열 생성
		for (int j = 0, a = 0; j < array[0].length; j++, a++) { //현재 배열의 맨 왼쪽아래부터 위쪽방향으로 탐색
			for (int i = array.length - 1, b = 0; i >= 0; i--, b++) {
				turned[a][b] = array[i][j];
			}
		}
		array = turned.clone();

	}

	private static void calc4() {//왼쪽으로 90도 바꾸기
		int[][] turned = new int[array[0].length][array.length];
		for (int j = array[0].length - 1, a = 0; j >= 0; j--, a++) {//현재 배열의 맨 오른쪽위부터 아래방향으로 탐색
			for (int i = 0, b = 0; i < array.length; i++, b++) {
				turned[a][b] = array[i][j];
			}
		}
		array = turned.clone();

	}

	private static void calc2() {//좌우반전
		for (int i = 0; i < array.length; i++) {//배열에 있는 요소들을 좌우 depth에 따라 복사
			for (int j = 0; j < array[0].length / 2; j++) {
				int temp = array[i][j];
				array[i][j] = array[i][array[0].length - 1 - j];
				array[i][array[0].length - 1 - j] = temp;
			}
		}

	}

	private static void calc1() {//상하반전

		for (int i = 0; i < array.length / 2; i++) {//이차원 배열이 가지고 있는 일차원 배열을 depth에 따라 복사
			int[] temp = array[i].clone();
			array[i] = array[array.length - 1 - i].clone();
			array[array.length - 1 - i] = temp;
		}

	}
}
