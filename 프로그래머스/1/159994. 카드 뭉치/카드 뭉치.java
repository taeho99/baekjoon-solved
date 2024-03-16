import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> c1 = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> c2 = new ArrayDeque<>(Arrays.asList(cards2));
        Queue<String> g = new ArrayDeque<>(Arrays.asList(goal));

        while(!g.isEmpty()) {
            if(!g.peek().equals(c1.peek()) && !g.peek().equals(c2.peek()))
                return "No";

            if(g.peek().equals(c1.peek())) {
                g.poll();
                c1.poll();
            } else {
                g.poll();
                c2.poll();
            }
        }
        return "Yes";
    }
}