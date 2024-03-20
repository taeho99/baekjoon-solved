import java.util.*;

class Solution {
    public String solution(String s) {
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        return list.get(0) + " " + list.get(list.size()-1);
    }
}