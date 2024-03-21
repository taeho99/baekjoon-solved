import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<26; i++) {
            map.put(String.valueOf((char)('A'+i)), i+1);
        }
        int idx=27;

        List<Integer> result = new ArrayList<>();
        for(int i=0; i<msg.length(); i++) {
            int a=1;
            while(a+i <= msg.length() && map.containsKey(msg.substring(i, i+a))) {
                a++;
            }
            if(a+i > msg.length()) {
                result.add(map.get(msg.substring(i)));
                break;
            }
            result.add(map.get(msg.substring(i, i+a-1)));
            map.put(msg.substring(i, i+a), idx++);
            if(a>1) i+=a-2;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}