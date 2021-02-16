package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1283_단축키지정 {
	static String[] menu;
	static char[] key;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		menu = new String[N];
		key = new char[N];
		for(int n=0;n<N;n++) {
			StringBuilder result = new StringBuilder();
			menu[n] = br.readLine();
			String[] menuSplit = menu[n].split(" ");
			
			boolean isSame = true;
			char first;
			for(int i=0;i<menuSplit.length;i++) {//첫번째 문장의 첫번째 알파벳 순회
				first = menuSplit[i].charAt(0);
				if(!String.valueOf(key).contains(Character.toString(first).toLowerCase())) {
					key[n]=Character.toLowerCase(first);
					menuSplit[i] = menuSplit[i].replaceFirst(Character.toString(first), "["+Character.toString(first)+"]");
					isSame = false;
					break;
				}
			}
			if(isSame) {//첫번째 문장 첫 알파벳에서 단축키를 못찾았다면 나머지 글자에서 찾는다.
				for(int i=0;i<menuSplit.length;i++) {
					for(int j=1;j<menuSplit[i].length();j++) {
						first = menuSplit[i].charAt(j);
						if(!String.valueOf(key).contains(Character.toString(first).toLowerCase())) {
							key[n]=Character.toLowerCase(first);
							menuSplit[i] = menuSplit[i].replaceFirst(Character.toString(first), "["+Character.toString(first)+"]");
							isSame = false;
							break;
						}
						if(!isSame) break;
					}
				}
			}
			for(String m :menuSplit) {
				result =result.append(m).append(" ");
			}
			System.out.println(result.toString());
		}
		
	}
}

