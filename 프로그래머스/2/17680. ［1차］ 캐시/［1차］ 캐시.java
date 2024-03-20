import java.util.ArrayDeque;
import java.util.Stack;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        int answer = 0;
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        for (String c : cities) {
            String city = c.toLowerCase();
            if(!queue.contains(city)) {
                answer += 5;
                if(queue.size() >= cacheSize) {
                    queue.pollFirst();
                }
                queue.addLast(city);
            } else {
                answer++;
                Stack<String> stack = new Stack<>();
                while(!queue.peekFirst().equals(city)) {
                    stack.push(queue.pollFirst());
                }
                queue.pollFirst();
                queue.addLast(city);
                while(!stack.isEmpty()) {
                    queue.addFirst(stack.pop());
                }
            }
        }
        return answer;
    }
}