import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        int[] user0 = {1,2,3,4,5}; // 5개
        int[] user1 = {2,1,2,3,2,4,2,5}; // 8개
        int[] user2 = {3,3,1,1,2,2,4,4,5,5}; // 10개
        int[] count = new int[3];
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == user0[i%5]) count[0]++;
            if(answers[i] == user1[i%8]) count[1]++;
            if(answers[i] == user2[i%10]) count[2]++;
        }
        
        int max = 0;
        for(int c : count) {
            if(c > max) max = c;
        }
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<count.length; i++) {
            if(max == count[i])
                answer.add(i+1);
        }
        return answer;
    }
}