import java.util.*;
class Solution {
    public String solution(String[] participants, String[] completions) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String participant : participants) {
            map.put(participant, map.getOrDefault(participant, 0) + 1);
        }
        for(String completion : completions) {
            map.put(completion, map.get(completion) - 1);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }
}