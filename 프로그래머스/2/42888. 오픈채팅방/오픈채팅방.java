import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> users = new HashMap<>();
        for (String r : record) {
            String[] split = r.split(" ");
            if(!split[0].equals("Leave"))
                users.put(split[1], split[2]);
        }
        List<String> answer = new ArrayList<>();
        for (String r : record) {
            String[] split = r.split(" ");
            if(split[0].equals("Enter")) {
                answer.add(users.get(split[1]) + "님이 들어왔습니다.");
            } else if (split[0].equals("Leave")) {
                answer.add(users.get(split[1]) + "님이 나갔습니다.");
            }
        }
        return answer.toArray(String[]::new);
    }
}