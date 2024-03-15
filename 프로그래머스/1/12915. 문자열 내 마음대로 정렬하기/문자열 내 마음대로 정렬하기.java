import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings).sorted().sorted(Comparator.comparingInt(s -> s.charAt(n))).toArray(String[]::new);
    }
}