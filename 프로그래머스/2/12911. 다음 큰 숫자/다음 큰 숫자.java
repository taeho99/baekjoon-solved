class Solution {
    public int solution(int n) {
        String binaryN = Integer.toBinaryString(n);
        int countN = 0;
        for(int i=0; i<binaryN.length(); i++) {
            if(binaryN.charAt(i) == '1')
                countN++;
        }

        int result = n+1;
        while(true) {
            String binaryResult = Integer.toBinaryString(result);
            int countResult = 0;
            for(int i=0; i<binaryResult.length(); i++) {
                if(binaryResult.charAt(i) == '1')
                    countResult++;
            }
            if(countResult == countN) {
                return result;
            } else {
                result++;
            }
        }
    }
}