import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] split = s.substring(2, s.length()-2).split("},\\{");
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(split, Comparator.comparingInt(String::length));
        for (String s1 : split) {
            String[] split2 = s1.split(",");
            for (String s2 : split2) {
                if(!list.contains(Integer.parseInt(s2))) {
                    list.add(Integer.parseInt(s2));
                }
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}