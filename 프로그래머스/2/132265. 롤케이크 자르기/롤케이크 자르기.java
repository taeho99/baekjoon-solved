import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> set1 = new HashMap<>();
        HashMap<Integer, Integer> set2 = new HashMap<>();
        for (int top : topping) {
            set2.put(top, set2.getOrDefault(top, 0) + 1);
        }
        
        for(int top : topping) {
            set1.put(top, set1.getOrDefault(top, 0) + 1);
            set2.put(top, set2.get(top) - 1);
            if(set2.get(top) == 0) {
                set2.remove(top);
            }
            if (set1.size() == set2.size()) answer++;
        }
        return answer;
    }
}