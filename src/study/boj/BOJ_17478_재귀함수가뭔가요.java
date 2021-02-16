package study.boj;
import java.util.Scanner;

public class BOJ_17478_재귀함수가뭔가요 {
	static String A = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
	static String B = "\"재귀함수가 뭔가요?\"\n";
	static String C = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";		
	static String C2 ="마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
	static String C3 ="그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	static String D = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
	static String E = "라고 답변하였지.\n";
	static int num;
	static StringBuilder sb = new StringBuilder();
	public static void printABCD(int n,int now) {
		StringBuilder r = new StringBuilder();
		for(int i=n+now;i>0;i--) {
			r.append("____");
		}
		sb.append(r).append(B);

		if(now==0) {
			sb.append(r).append(D);

			return;
		}
		sb.append(r).append(C);
		sb.append(r).append(C2);
		sb.append(r).append(C3);

		
		printABCD(n,now+1);
	}
	public static void printE(int n) {
		StringBuilder r = new StringBuilder();
		for(int i=0;i<n;i++) {
			r.append("____");
		}
		if(n<0) return;
		sb.append(r).append(E);

		printE(n-1);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		num = sc.nextInt();
		System.out.println(A);
		printABCD(num, -num);
		printE(num);
		System.out.println(sb.toString());
	}
}
