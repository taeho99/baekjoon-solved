import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        int[] result = new int[set.size()];
        for(int i=0; i<result.length; i++) {
            result[i] = set.pollFirst();
        }
        return result;
    }
}