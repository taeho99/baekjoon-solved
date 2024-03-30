import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int hIndex = Math.min(citations.length, citations[citations.length - 1]);
        while(true) {
            int count = 0;
            for (int citation : citations) {
                if(citation >= hIndex)
                    count++;
            }

            if(count >= hIndex) {
                return hIndex;
            }
            hIndex--;
        }
    }
}