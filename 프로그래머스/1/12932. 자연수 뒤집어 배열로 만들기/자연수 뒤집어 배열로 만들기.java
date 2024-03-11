class Solution {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        int[] answer = new int[s.length()];
        for(int i=s.length() - 1, j=0; i>=0; i--, j++) {
            answer[j] = s.charAt(i) - '0';
        }
        return answer;
    }
}