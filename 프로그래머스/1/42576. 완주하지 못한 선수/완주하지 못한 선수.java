import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        for (String s : map.keySet()) {
            if(map.get(s) == 1) {
                answer = s;
                break;
            }
        }
        return answer;
    }
}