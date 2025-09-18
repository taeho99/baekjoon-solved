import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        for(String operation : operations) {
            String[] cmd = operation.split(" ");
            if(cmd[0].equals("D") && maxQ.isEmpty()) continue;
            
            if(cmd[0].equals("I")) {
                maxQ.add(Integer.parseInt(cmd[1]));
                minQ.add(Integer.parseInt(cmd[1]));
            } else if (cmd[1].equals("1")) {
                minQ.remove(maxQ.poll());
            } else if (cmd[1].equals("-1")) {
                maxQ.remove(minQ.poll());
            }
        }
        
        if(maxQ.isEmpty()) return new int[] {0, 0};
        else return new int[] {maxQ.poll(), minQ.poll()};
    }
}