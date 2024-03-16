import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int n = name.length;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(name[i], yearning[i]);
        }
        int[] answer = new int[photo.length];
        for(int i=0; i<photo.length; i++) {
            for (String p : photo[i]) {
                answer[i] += map.getOrDefault(p, 0);
            }
        }
        return answer;
    }
}