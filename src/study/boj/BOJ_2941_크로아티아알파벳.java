package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941_크로아티아알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		s = s.replace("dz=", " ");
		s = s.replace("lj", " ");
		s = s.replace("nj", " ");
		s = s.replace("c=", " ");
		s = s.replace("c-", " ");
		s = s.replace("d-", " ");
		s = s.replace("s=", " ");
		s = s.replace("z=", " ");	
		
		System.out.println(s.length());
	}
}
