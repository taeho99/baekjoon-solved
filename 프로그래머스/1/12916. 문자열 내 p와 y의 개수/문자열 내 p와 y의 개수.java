class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCount = 0;
        int yCount = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'p' || c == 'P') pCount++;
            else if (c == 'y' || c == 'Y') yCount++;
        }
        if(pCount != yCount) answer = false;

        return answer;
    }
}