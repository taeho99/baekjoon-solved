import java.util.*;

class Solution {
    public int solution(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        int n = s.length();
        s += s;
        int result = 0;

      A:for(int i=0; i<n; i++) {
            Stack<Character> stack = new Stack<>();
            for(int j=i; j<i+n; j++) {
                char c = s.charAt(j);
                if(!map.containsKey(c)) { //열리는 괄호인 경우
                    stack.push(c);
                } else { //닫히는 괄호인 경우
                    if(stack.isEmpty() || !stack.pop().equals(map.get(c)))
                        continue A;
                }
            }
            if(stack.isEmpty())
                result++;
        }
        return result;
    }
}