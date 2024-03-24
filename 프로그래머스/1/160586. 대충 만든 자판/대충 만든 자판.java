import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (String k : keymap) {
            for(int i=1; i<=k.length(); i++) {
                char c = k.charAt(i-1);
                int value = map.getOrDefault(c, 101);
                if (i < value) {
                    map.put(c, i);
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (String t : targets) {
            int sum = 0;
            for(int i=0; i<t.length(); i++) {
                char c = t.charAt(i);
                if(!map.containsKey(c)) {
                    sum = -1;
                    break;
                }
                sum += map.get(c);
            }
            answer.add(sum);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

}