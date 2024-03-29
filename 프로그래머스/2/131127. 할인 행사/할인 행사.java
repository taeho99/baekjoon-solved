import java.util.*;

class Solution {
   public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> me = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            me.put(want[i], number[i]);
        }

        HashMap<String, Integer> mart = new HashMap<>();
        for(int i=0; i<10; i++) {
            mart.put(discount[i], mart.getOrDefault(discount[i], 0) + 1);
        }

        int result = 0;
        for(int i=0; i<discount.length - 9; i++) {
            if(me.equals(mart)) result++;
            if(i != discount.length - 10) {
                mart.put(discount[i], mart.get(discount[i]) - 1);
                if(mart.get(discount[i]) == 0)
                    mart.remove(discount[i]);
                mart.put(discount[i + 10], mart.getOrDefault(discount[i + 10], 0) + 1);

            }
        }
        return result;
    }
}