import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] batch = {0, 3, 2, 1, 0, 1, 2, 3};
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<survey.length; i++) {
            char c1 = survey[i].charAt(0);
            char c2 = survey[i].charAt(1);
            int score = choices[i];
            
            if(score < 4) {
                map.put(c1, map.getOrDefault(c1, 0) + batch[score]);
            } else if (score > 4) {
                map.put(c2, map.getOrDefault(c2, 0) + batch[score]);
            }
        }
        String result = "";
        
        char[] seq = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for(int i=0; i<seq.length; i+=2) {
            if(map.getOrDefault(seq[i], 0) >= map.getOrDefault(seq[i+1], 0)) {
                result += seq[i];
            } else {
                result += seq[i+1];
            }
        }
        
        return result;
    }
}