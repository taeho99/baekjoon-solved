import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int n = arr[arr.length-1];
        while(true) {
            boolean flag = true;
            for(int i=0; i< arr.length; i++) {
                if(n % arr[i] != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) return n;
            n++;
        }
    }
}