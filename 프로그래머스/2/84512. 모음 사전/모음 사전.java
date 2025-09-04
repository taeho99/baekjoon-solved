import java.util.*;
class Solution {
    char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    int ans = 0;
    public int solution(String word) {
        List<String> list = new ArrayList<>();
        dfs(0, "", word, list);
        return ans;
    }
    
    void dfs(int depth, String word, String correct, List<String> list) {
        
        list.add(word);
        if(ans != 0) return;
        if(word.equals(correct)) {
            ans = list.size() - 1;
        }
        if(depth == 5) return;
        for(int idx=0; idx<5; idx++) {
            dfs(depth + 1, word + alpha[idx], correct, list);
        }
    }
}