import java.util.*;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        HashMap<String, Integer> reported = new HashMap<>();
        for (String i : id_list) {
            map.put(i, new ArrayList<>());
        }
        for (String r : report) {
            String[] split = r.split(" ");
            if(!map.get(split[0]).contains(split[1])) {
                reported.put(split[1], reported.getOrDefault(split[1], 0) + 1);
                map.get(split[0]).add(split[1]);
            }
        }

        int[] answer = new int[id_list.length];
        List<String> idlist = Arrays.asList(id_list);
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            for (String r : entry.getValue()) {
                if(reported.getOrDefault(r, 0) >= k) {
                    answer[idlist.indexOf(entry.getKey())] += 1;
                }
            }
        }
        return answer;
    }
}