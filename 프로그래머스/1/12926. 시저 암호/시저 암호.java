class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                sb.append(c);
                continue;
            }
            if('a' <= c && c <= 'z') {
                c = (char) (c + n);
                if(c > 'z') {
                    c -= 26;
                }
            } else {
                c = (char) (c + n);
                if(c > 'Z') {
                    c -= 26;
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}