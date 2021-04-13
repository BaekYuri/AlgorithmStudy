package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014_활주로건설 {
	static int N, X;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T =Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result= 0;
			for(int i=0;i<N;i++) {
				int now = map[i][0];
				boolean cango = true;
				outer : for(int j=1;j<N;j++) {
					if(map[i][j]==now) continue;
					if(map[i][j]!=now && Math.abs(map[i][j]-now)==1) {
						if(map[i][j] == now+1) {
							if(j-X>=0) {
								for(int k=1;k<=X;k++) {
									if(map[i][j-k]!=now) {
										cango = false;
										break outer;
									}
								}
								
									for(int k=j-2*X>=0?j-2*X:0;k<j-X;k++) {
										if(map[i][j]==map[i][k]) {
											cango = false;
											break outer;
										}
									}
								
							}else {
								cango = false;
								break outer;
							}
						}else if (map[i][j] == now-1){
							if(j+X-1<N) {
								for(int k=0;k<=X-1;k++) {
									if(map[i][j+k]!=now-1) {
										cango = false;
										break outer;
									}
								}
								
									for(int k=j+X;k<=(j+2*X-1<N?j+2*X-1:N-1);k++) {
										if(map[i][j-1]==map[i][k]) {
											cango = false;
											break outer;
										}
									}
									
								
							}else {
								cango = false;
								break outer;
							}
						}else {
							cango = false;
							break;
						}
						now = map[i][j];
					}else {
						cango = false;
						break;
					}
					
				}
				if(cango) result++;
			}
			
			for(int i=0;i<N;i++) {
				int now = map[0][i];
				boolean cango = true;
				outer : for(int j=1;j<N;j++) {
					if(map[j][i]==now) continue;
					if(map[j][i]!=now && Math.abs(map[j][i]-now)==1) {
						if(map[j][i] == now+1) {
							if(j-X>=0) {
								for(int k=1;k<=X;k++) {
									if(map[j-k][i]!=now) {
										cango = false;
										break outer;
									}
								}
								
									for(int k=j-2*X>=0?j-2*X:0;k<j-X;k++) {
										if(map[j][i]==map[k][i]) {
											cango = false;
											break outer;
										}
									}
								
							}else {
								cango = false;
								break outer;
							}
						}else if (map[j][i] == now-1){
							if(j+X-1<N){
							for(int k=0;k<=X-1;k++) {
								if(map[j+k][i]!=now-1) {
									cango = false;
									break outer;
								}
							}
								for(int k=j+X;k<=(j+2*X-1<N?j+2*X-1:N-1);k++) {
									if(map[j-1][i]==map[k][i]) {
										cango = false;
										break outer;
									}
								}
							
							}else {
								cango = false;
								break outer;
							}
						}else {
							cango = false;
							break;
						}
						now = map[j][i];
					}else {
						cango = false;
						break;
					}
				}
				if(cango) result++;
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
