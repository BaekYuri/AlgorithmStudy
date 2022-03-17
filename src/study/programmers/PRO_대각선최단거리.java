package study.programmers;

public class PRO_대각선최단거리 {
    static public int solution(int width, int height, int[][] diagonals) {
        long answer = 0;
        
        width = width+1;
        height = height+1;
        //대각선이 없을 때 최단 거리 구하기
        long[][] shortRoad = new long[height][width];
        for(int i=0;i<width;i++) {
        	shortRoad[height-1][i] = 1;
        }
        for(int i=0;i<height;i++) {
        	shortRoad[i][0]=1;
        }
        for(int i=height-2;i>=0;i--) {
        	for(int j=1;j<width;j++) {
        		shortRoad[i][j] = ((shortRoad[i+1][j])%10000019 + (shortRoad[i][j-1])%10000019)%10000019;
        	}
        }
        
        for(int i=0, size=diagonals.length;i<size;i++) {
        	int nowX = height-diagonals[i][0];
        	int nowY = diagonals[i][1]-1;
        	
        	answer = (answer%10000019+((shortRoad[nowX-1][nowY])%10000019*(shortRoad[height-1-nowX][width-nowY-2])%10000019)%10000019)%10000019;
        	answer = (answer%10000019+((shortRoad[nowX][nowY+1])%10000019*(shortRoad[height-nowX][width-nowY-1])%10000019)%10000019)%10000019;
        }
        return (int)answer;
    }
    public static void main(String[] args) {
		solution(51, 37, new int[][] {{17,19}});
	}
}
