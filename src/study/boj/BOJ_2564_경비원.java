package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2564_경비원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		
		int[][] locate = new int[N][2];
		
		int myR, myC;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			locate[i][0]= Integer.parseInt(st.nextToken());
			locate[i][1]= Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		myR =  Integer.parseInt(st.nextToken());
		myC =  Integer.parseInt(st.nextToken());
		int result =0;
		for(int i=0;i<N;i++) {
			switch(myR) {
			case 1:
				if(locate[i][0]==1) {
					result+=Math.abs(myC-locate[i][1]);
				}else if(locate[i][0]==2) {
					int a =myC+locate[i][1];
					int b = 2*R - a;
					result+= C+Integer.min(a, b);
				}else if(locate[i][0]==3) {
					result += myC+locate[i][1];
				}else {
					result += (R-myC)+locate[i][1];
				}
				break;
			case 2:
				if(locate[i][0]==1) {
					int a =myC+locate[i][1];
					int b = 2*R - a;
					result+= C+Integer.min(a, b);
				}else if(locate[i][0]==2) {
					result+=Math.abs(myC-locate[i][1]);
				}else if(locate[i][0]==3) {
					result += myC+C-locate[i][1];
				}else {
					result += (R-myC)+C-locate[i][1];
				}
				break;
			case 3:
				if(locate[i][0]==1) {
					result += myC+locate[i][1];
				}else if(locate[i][0]==2) {
					result += C-myC+locate[i][1];
				}else if(locate[i][0]==3) {
					result+=Math.abs(myC-locate[i][1]);
				}else {
					int a =myC+locate[i][1];
					int b = 2*R - a;
					result+= R+Integer.min(a, b);
				}
				break;
			case 4:
				if(locate[i][0]==1) {
					result += myC+R-locate[i][1];
				}else if(locate[i][0]==2) {
					result += C-myC+R-locate[i][1];
				}else if(locate[i][0]==3) {
					int a =myC+locate[i][1];
					int b = 2*R - a;
					result+= R+Integer.min(a, b);
				}else {
					result+=Math.abs(myC-locate[i][1]);
					
				}
				break;
			}
		}
		System.out.println(result);
		
	}
}
