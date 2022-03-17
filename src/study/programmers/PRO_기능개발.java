package study.programmers;

import java.util.ArrayList;
import java.util.List;

public class PRO_기능개발 {
	static public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> answerList = new ArrayList<>();
		
		int nowIdx = 1;
		
		int finishedTime = (100-progresses[0])/speeds[0];
		
		if((100-progresses[0])%speeds[0]!=0) {
			finishedTime++;
		}
		
		int finishedJob = 1;
		int size = progresses.length;
		
		while(nowIdx < size){
			int toFinishDay = (100-progresses[nowIdx])/speeds[nowIdx];
			
			if((100-progresses[nowIdx])%speeds[nowIdx]!=0) {
				toFinishDay++;
			}
			
			if(finishedTime >= toFinishDay) {
				finishedJob++;
			}else {
				finishedTime = toFinishDay;
				answerList.add(finishedJob);
				finishedJob = 1;
			}
			nowIdx++;
		}
		
		answerList.add(finishedJob);
		
        int[] answer = new int[answerList.size()];
        int tempIdx = 0;
        for(int ans : answerList) {
        	answer[tempIdx++] = ans;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		solution(new int[] {93, 92, 91}, new int[] {1, 1, 1});
	}
}
