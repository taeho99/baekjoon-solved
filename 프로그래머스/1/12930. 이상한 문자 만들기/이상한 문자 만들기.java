class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                idx = 0;
                sb.append(' ');
            } else {
                if(idx%2 == 0)
                    sb.append(("" + c).toUpperCase());
                else
                    sb.append(("" + c).toLowerCase());
                idx++;
            }
        }
        return sb.toString();
    }
}