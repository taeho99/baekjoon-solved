class Solution {
    boolean[] visited;
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(0, begin, target, words);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    void dfs(int depth, String begin, String target, String[] words) {
        if(begin.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }
        
        if(depth == words.length) {
            return;
        }
        
        for(int idx=0; idx<words.length; idx++) {
            if(!visited[idx] && isDiffOne(begin, words[idx])) {
                visited[idx] = true;
                dfs(depth+1, words[idx], target, words);
                visited[idx] = false;
            }
        }
    }
    
    boolean isDiffOne(String str1, String str2) {
        int diffCnt = 0;
        for(int idx=0; idx<str1.length(); idx++) {
            if(str1.charAt(idx) != str2.charAt(idx)) diffCnt++;
        }
        return diffCnt == 1;
    }
}