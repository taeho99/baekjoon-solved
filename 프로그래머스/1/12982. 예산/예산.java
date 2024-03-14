import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;
        for (int i : d) {
            budget -= i;
            if(budget < 0)
                return count;
            count++;
        }
        return count;
    }
}