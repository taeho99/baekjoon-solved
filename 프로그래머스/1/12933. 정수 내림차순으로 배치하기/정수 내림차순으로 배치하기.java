import java.util.*;

class Solution {
    public long solution(long n) {
        String s = String.valueOf(n);
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        StringBuilder answer = new StringBuilder();
        for(int i=charArray.length - 1; i>=0; i--) {
            answer.append(charArray[i]);
        }
        return Long.parseLong(answer.toString());
    }
}