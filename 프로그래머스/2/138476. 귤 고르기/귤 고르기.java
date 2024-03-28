import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());

        int sum = 0;
        int answer = 0;
        for(int i=0; i<list.size(); i++) {
            sum += list.get(i);
            if(sum >= k) {
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}