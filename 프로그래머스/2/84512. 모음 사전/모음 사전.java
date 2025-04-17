import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static String[] words = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        dfs("", 0);
        for(int idx=0; idx<list.size(); idx++) {
            if (word.equals(list.get(idx))) return idx;
        }
        return -1;
    }
    
    static void dfs(String str, int depth) {
        list.add(str);
        if(depth == 5) return;
        
        for(int idx=0; idx<5; idx++) {
            dfs(str + words[idx], depth + 1);
        }
    }
}