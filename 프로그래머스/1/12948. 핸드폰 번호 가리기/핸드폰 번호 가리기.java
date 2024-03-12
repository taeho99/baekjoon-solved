class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        int length = phone_number.length();
        for(int i=0; i<length; i++) {
            if(i < length - 4) {
                sb.append('*');
            } else {
                sb.append(phone_number.charAt(i));
            }
        }
        return sb.toString();
    }
}