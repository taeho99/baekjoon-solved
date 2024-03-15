import java.util.*;

class Solution {
    public int solution(String s) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            s = s.replace(entry.getValue(), String.valueOf(entry.getKey()));
        }
        return Integer.parseInt(s);
    }
}