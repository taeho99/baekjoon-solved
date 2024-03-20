class Solution {
    public String solution(String s) {
        boolean isFirst = true;
        StringBuilder result = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(isFirst) {
                result.append(s.substring(i, i+1).toUpperCase());
                isFirst = false;
            } else {
                result.append(s.substring(i, i+1).toLowerCase());
            }

            if(s.charAt(i) == ' ') {
                isFirst = true;
            }
        }
        return result.toString();
    }
}