class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;
        
        for(int idx=0; idx<name.length(); idx++) {
            answer += Math.min(name.charAt(idx) - 'A', 26 - (name.charAt(idx) - 'A'));
            if (idx < name.length() - 1 && name.charAt(idx+1) == 'A') {
                int endIdx = idx + 1;
                while(endIdx < name.length() && name.charAt(endIdx) == 'A')
                    endIdx++;
                move = Math.min(move, idx * 2 + (name.length() - endIdx));
                move = Math.min(move, idx + (name.length() - endIdx) * 2);
            }
        }
        return answer + move;
    }
}