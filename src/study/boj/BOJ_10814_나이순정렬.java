package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10814_나이순정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(br.readLine());
		Profile[] profiles = new Profile[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			profiles[i] = new Profile(Integer.parseInt(st.nextToken()), st.nextToken(), i);
		}
		Arrays.sort(profiles);
		StringBuilder sb =new StringBuilder();
		for(Profile p: profiles) {
			sb.append(p.toString()).append("\n");
		}
		System.out.println(sb);
	}
	static class Profile implements Comparable<Profile>{
		int age;
		String name;
		int number;
		
		public Profile(int age, String name, int number) {
			super();
			this.age = age;
			this.name = name;
			this.number = number;
		}


		@Override
		public int compareTo(Profile o) {
			if(this.age!=o.age){
				return Integer.compare(this.age, o.age);
			}else {
				return Integer.compare(this.number, o.number);
			}
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return age+" "+name;
		}
	}
}
