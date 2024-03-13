import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s.chars().mapToObj(i -> (char)i).sorted(Comparator.reverseOrder()).forEach(sb::append);
        return sb.toString();
    }
}