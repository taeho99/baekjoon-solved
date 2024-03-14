import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>(); //인덱스 push
        stack.push(0); // 1초때 1원 추가

        for(int i=1; i<n; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int pop = stack.pop();
                answer[pop] = i - pop;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int i = stack.pop();
            answer[i] = n - 1 - i;
        }

        return answer;
    }
}