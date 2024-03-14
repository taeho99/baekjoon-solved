class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n != 0) {
            sb.append(n%3);
            n/=3;
        }
        String n3 = sb.toString();
        int answer =0 ;
        for(int i=0; i<n3.length(); i++) {
            answer += (int) (Math.pow(3, i) * (n3.charAt(n3.length()-i-1) - '0'));
        }

        return answer;
    }
}