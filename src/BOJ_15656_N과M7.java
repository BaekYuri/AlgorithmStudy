import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15656_N과M7 {
	
	static int number[];
	static int line[];
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	static void get(int from, int to) {
		if(from==to) {
			for(int a:line) {
				sb.append(a).append(" ");
				
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<number.length;i++) {
			
			line[from]=number[i];

			get(from+1, to);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		number = new int[N];

		line = new int[M];
		s = br.readLine();
		st = new StringTokenizer(s);
		for(int i=0;i<N;i++) {
			number[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(number);
		
		get(0,M);
		
		System.out.println(sb);
	}
}
