
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; sb.length() < t*m; i++) {
            sb.append(Integer.toString(i, n).toUpperCase());
        }
        System.out.println(sb.toString());
        StringBuilder result = new StringBuilder();
        for(int i=p-1; ; i+=m) {
            if(result.length() == t) {
                break;
            }
            result.append(sb.charAt(i));
        }

        return result.toString();
    }
}