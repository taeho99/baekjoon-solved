import java.util.*;
import java.util.stream.Collectors;
class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> set = Arrays.stream(win_nums).boxed().collect(Collectors.toSet());
        System.out.println(set);
        int min = 0;
        int max = 0;

        for (int lotto : lottos) {
            if(set.contains(lotto)) {
                min++;
                max++;
            } else if (lotto == 0) {
                max++;
            }
        }

        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        return new int[]{rank[max], rank[min]};
    }
}