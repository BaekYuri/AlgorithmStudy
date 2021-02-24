package study.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정올_1037_오류교정 {
	static int N;
	static int[][] array;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());// 1.	행렬의 크기(N)을 입력받는다.
		array = new int[N][N];
		int[] rowCount = new int[N];	//2.	행과 열의 1의 개수를 저장할 배열 두개 생성
		int[] colCount = new int[N];
		for(int i=0;i<N;i++) {		//3.	행렬 각각의 요소를 입력받는다. 받으면서 
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {	
				int temp = Integer.parseInt(st.nextToken());
				array[i][j] = temp;
				if(temp ==1) {		//1인 요소가 등장할 때에는 각 행과 열의 count++
					rowCount[i]++;
					colCount[j]++;
				}
			}
		}
		// 짝수패리티가 아닌 행 열이 있는지 확인하기 위한 변수
		int row = -1;	//변경하지 않았다는 것을 표시하기 위해 초기값 -1 설정
		int col = -1;
		for(int i=0;i<N;i++) { // 4. 0부터 N-1까지 순회하면서, rowCount와 colCount에 홀수인 경우가 있는지 찾아본다.
			if(rowCount[i]%2 !=0) {
				if(row !=-1) {		//5. 만약 row나 col에 홀수인 경우가 2가지 이상 있다면 바로 Currupt를 출력하고 프로그램 종료
					System.out.println("Corrupt");
					return;
				}else {
					row = i;
				}
			}
			if(colCount[i]%2 !=0) {
				if(col !=-1) {
					System.out.println("Corrupt");
					return;
				}else {
					col = i;
				}
			}
		}
		if(row == -1 && col == -1) { // Row와 col에 홀수인 경우가 없다면 -> OK
			System.out.println("OK");
			return;
		}else {						// 각각 한가지 씩 있다면 -> Change(I,j)
			StringBuilder sb = new StringBuilder();
			sb.append("Change bit (").append(row+1).append(",").append(col+1).append(")");
			System.out.println(sb);
			return;
		}
	}
}
