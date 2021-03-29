package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1755_숫자놀이{
	static int M, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //M과 N 입력
		N = Integer.parseInt(st.nextToken());
		
		MyNumber[] numList = new MyNumber[N-M+1];//M과 N 사이의 갯수만큼 배열 생성
		for(int i=M, t=0;i<=N;i++, t++) {//숫자와 숫자의 문자버전 MyNumber 객체로 저장
			numList[t] = new MyNumber(i, numToStr(i));
		}
		
		Arrays.sort(numList);//사전순으로 정렬
		
		StringBuilder result = new StringBuilder();
		
		for(int t=0;t<numList.length;t++) {
			result.append(numList[t].number).append(" ");//결과 만들기
			
			if(t%10 == 9) {//한줄에 10개 출력한다.
				result.append("\n");
			}
		}
		System.out.println(result);
	}
	static String numToStr(int n) {
		String num = Integer.toString(n);//n을 문자열 형태로 저장
		StringBuilder changed= new StringBuilder();
		for(int i=0;i<num.length();i++) {
			switch(num.charAt(i)) {//숫자에 따라 문자열 다르게 저장
			case '0':
				changed.append("zero");
				break;
			case '1':
				changed.append("one");
				break;
			case '2':
				changed.append("two");
				break;
			case '3':
				changed.append("three");
				break;
			case '4':
				changed.append("four");
				break;
			case '5':
				changed.append("five");
				break;
			case '6':
				changed.append("six");
				break;
			case '7':
				changed.append("seven");
				break;
			case '8':
				changed.append("eight");
				break;
			case '9':
				changed.append("nine");
				break;
			}
			changed.append(" ");
		}
		changed.deleteCharAt(changed.length()-1); //마지막 띄어쓰기는 지우기
		return changed.toString();
	}
	static class MyNumber implements Comparable<MyNumber>{//숫자와 문자열 저장할 객체
		int number;
		String str;
		
		public MyNumber(int number, String str) {
			super();
			this.number = number;
			this.str = str;
		}

		@Override
		public int compareTo(MyNumber o) {//비교하는 기준 설정
			
			return this.str.compareTo(o.str);
		}
		
	}
}

