package study.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PRO_네트워크 {
	static public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for(int i=0;i<n;i++) {
        	if(visited[i]) continue;
        	visited[i] = true;
        	answer++;
        	Queue<int[]> road = new LinkedList<>();
        	for(int x=0;x<n;x++) {
        		if(i!=x && computers[i][x]==1) {
        			road.add(new int[] {i, x});
        		}
        	}
        	while(!road.isEmpty()) {
        		int[] nowRoad = road.poll();
        		if(!visited[nowRoad[1]]) {
        			visited[nowRoad[1]] = true;
        			for(int x=0;x<n;x++) {
                		if(nowRoad[1]!=x && computers[nowRoad[1]][x]==1) {
                			road.add(new int[] {nowRoad[1], x});
                		}
                	}
        		}
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
	}
}
