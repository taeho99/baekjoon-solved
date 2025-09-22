import java.util.*;
class Solution {
    HashMap<String, List<Integer>> map = new HashMap<>();
    public int[] solution(String[] infos, String[] query) {
        int[] answer = new int[query.length];
        
        for(String info : infos) {
            String[] data = info.split(" ");
            makeMap(data, "", 0); 
        }
        
        for(List<Integer> scoreList : map.values()) {
            Collections.sort(scoreList);
        }
        
        for(int idx=0; idx<query.length; idx++) {
            query[idx] = query[idx].replaceAll(" and ", "");
            String[] queryData = query[idx].split(" ");
            if(map.containsKey(queryData[0])) {
                answer[idx] = binarySearch(queryData[0], Integer.parseInt(queryData[1]));
            } else {
                answer[idx] = 0;
            }
        }
        return answer;
    }
    
    int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start=0, end=list.size()-1;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            if(list.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return list.size() - start;
    }
    
    void makeMap(String[] data, String str, int depth) {
        if(depth == data.length - 1) {
            if(!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(Integer.parseInt(data[4]));
            return;
        }
        makeMap(data, str + "-", depth+1);
        makeMap(data, str + data[depth], depth+1);
    }
    
    boolean isOk(String[] data, String[] queryData) {
        if(!queryData[0].equals("-") && !queryData[0].equals(data[0])) return false;
        if(!queryData[2].equals("-") && !queryData[2].equals(data[1])) return false;
        if(!queryData[4].equals("-") && !queryData[4].equals(data[2])) return false;
        if(!queryData[6].equals("-") && !queryData[6].equals(data[3])) return false;
        if(Integer.parseInt(data[4]) < Integer.parseInt(queryData[7])) return false;
        return true;
    }
}