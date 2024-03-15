class Solution {
    public String solution(int[] food) {
        int n = food.length;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n; i++) {
            food[i] /= 2;
            for(int j=0; j<food[i]; j++) {
                sb.append(i);
            }
        }
        sb.append(0);
        for(int i=sb.length()-2; i>=0; i--) {
            sb.append(sb.charAt(i));
        }
        return sb.toString();
    }
}