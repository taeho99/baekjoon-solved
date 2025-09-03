import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        int[][] supo = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int max = -1;
        int[] result = new int[3];
        for(int idx=0; idx<3; idx++) {
            for(int answerIdx=0; answerIdx<answers.length; answerIdx++) {
                if(supo[idx][answerIdx%supo[idx].length] == answers[answerIdx]) result[idx]++;
            }
            max = Math.max(max, result[idx]);
        }
        List<Integer> answer = new ArrayList<>();
        for(int idx=0; idx<3; idx++) {
            if(max == result[idx]) answer.add(idx+1);
        }
        return answer;
    }
}