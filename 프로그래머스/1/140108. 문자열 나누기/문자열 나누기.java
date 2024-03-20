class Solution {
    public int solution(String s) {
        int xNum = 1, yNum = 0, answer = 0;
        char x = s.charAt(0);
        for(int i=1; i<s.length(); i++) {
            if(xNum == yNum) {
                answer++;
                x = s.charAt(i);
            }

            if(s.charAt(i) == x) {
                xNum++;
            } else {
                yNum++;
            }
        }
        return answer+1;
    }
}