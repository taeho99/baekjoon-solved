import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int m : moves) {
            for(int i=0; i<n; i++) {
                int item = board[i][m-1];
                if(item == 0)
                    continue;
                board[i][m-1] = 0;
                if(!stack.isEmpty() && stack.peek() == item) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(item);
                }
                break;
            }
        }
        return answer;
    }
}