import java.util.*;

public class Solution {
    public Integer[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int a : arr) {
            if (stack.peek() != a)
                stack.push(a);
        }
        return stack.toArray(Integer[]::new);
    }
}