import java.util.ArrayList;

class Solution {
    public String solution(String X, String Y) {
        ArrayList<Character> list = new ArrayList<>();
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        int[] count = new int[10];

        for(int i=0; i<X.length(); i++) {
            int n = X.charAt(i) - '0';
            xCount[n]++;
        }
        for(int i=0; i<Y.length(); i++) {
            int n = Y.charAt(i) - '0';
            yCount[n]++;
        }
        boolean isValid = false;
        for(int i=0; i<10; i++) {
            count[i] = Math.min(xCount[i], yCount[i]);
            if(count[i] != 0) {
                isValid = true;
            }
        }
        if(!isValid) {
            return "-1";
        }

        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            if(i == 0 && sb.length() == 0) {
                return "0";
            }
            for(int j=0; j<count[i]; j++) {
                sb.append(i);
            }
        }

        return sb.toString();
    }
}