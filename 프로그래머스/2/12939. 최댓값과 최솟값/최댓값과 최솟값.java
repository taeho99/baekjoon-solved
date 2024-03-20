import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while(st.hasMoreTokens()) {
            int now = Integer.parseInt(st.nextToken());
            min = Math.min(now, min);
            max = Math.max(now, max);
        }
        return min + " " + max;
    }
}