import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        int[] array = Arrays.stream(arr).filter(i -> i != min).toArray();
        if(array.length == 0)
            return new int[] {-1};
        return array;
    }
}