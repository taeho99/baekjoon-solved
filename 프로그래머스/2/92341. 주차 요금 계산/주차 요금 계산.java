import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> answer = new HashMap<>();
        HashMap<String, Integer> inMap = new HashMap<>();
        HashMap<String, Integer> outMap = new HashMap<>();
        for(String record : records) {
            String[] data = record.split(" ");
            String[] hhmm = data[0].split(":");
            int time = Integer.parseInt(hhmm[0]) * 60 + Integer.parseInt(hhmm[1]);
            
            if (data[2].equals("IN")) {
                inMap.put(data[1], time);
            } else {
                int diffTime = time - inMap.get(data[1]);
                outMap.put(data[1], outMap.getOrDefault(data[1], 0) + diffTime);
                inMap.remove(data[1]);
            }
        }
        
        for(Map.Entry<String, Integer> entry : inMap.entrySet()) {
            int time = 23 * 60 + 59;
            int diffTime = time - entry.getValue();
            outMap.put(entry.getKey(), outMap.getOrDefault(entry.getKey(), 0) + diffTime);
        }
        
        for (Map.Entry<String, Integer> entry : outMap.entrySet()) {
            int fee = getFee(fees, entry.getValue());
            answer.put(entry.getKey(), answer.getOrDefault(entry.getKey(), 0) + fee);
        }
        
        List<String[]> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : answer.entrySet()) {
            result.add(new String[] {entry.getKey(), "" + entry.getValue()});
        }
        Collections.sort(result, (o1, o2) -> o1[0].compareTo(o2[0]));
        
        int[] ret = new int[result.size()];
        for(int idx=0; idx<ret.length; idx++) {
            ret[idx] = Integer.parseInt(result.get(idx)[1]);
        }
        
        return ret;
    }
    
    int getFee(int[] fees, int time) {
        if(time <= fees[0]) {
            return fees[1];
        }
        return fees[1] + (((time - fees[0] + fees[2] - 1)/fees[2]) * fees[3]);
    }
}