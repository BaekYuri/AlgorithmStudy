package study.boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12025_장난꾸러기영훈 {
	static String password;
	static long K;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		password = br.readLine();
		for(int i=0;i<password.length();i++) {
			if(password.charAt(i)=='2' || password.charAt(i)=='7'||password.charAt(i)=='1'||password.charAt(i)=='6') {
				count++;
			}
		}
		
		K = Long.parseLong(br.readLine());
		//2 --> 2진수로 생각해서 10 --> 00 01 10 11 이런식으로 오름차순이니까 01이 2번쨰잖아요 -1
		if(K<=0 || K>Math.pow(2, count)) {
			System.out.println(-1);
			return;
		}
		K--;
//		String result = Long.toBinaryString(K-1);
		StringBuilder sb= new StringBuilder();
		for(int i=0, t=count-1;i<password.length();i++) {
			switch(password.charAt(i)) {
			case '1':
			case '6':
				if((K & (1<<t)) == 0) {
					sb.append(1);
				}else {
					sb.append(6);
				}
				t--;
				break;
			case '2':
			case '7':
				if((K & (1<<t)) == 0) {
					sb.append(2);
				}else {
					sb.append(7);
				}
				t--;
				break;
			default:
				sb.append(password.charAt(i));
				break;
			}
		}
		System.out.println(sb);
		
		
	}
	
}
