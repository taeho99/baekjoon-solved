import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for(int i=0; i<n; i++) {
            String binary1 = Integer.toBinaryString(arr1[i]);
            int len1 = binary1.length();
            String binary2 = Integer.toBinaryString(arr2[i]);
            int len2 = binary2.length();
            for(int j=0; j<n-len1; j++) {
                binary1 = "0" + binary1;
            }

            for(int j=0; j<n-len2; j++) {
                binary2 = "0" + binary2;
            }

            System.out.println(binary1);
            System.out.println(binary2);
            System.out.println();

            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++) {
                sb.append(binary1.charAt(j) == '1' || binary2.charAt(j) == '1' ? '#' : ' ');
            }
            result[i] = sb.toString();
        }
        return result;
    }
}