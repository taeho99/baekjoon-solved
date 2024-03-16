import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> p = new ArrayDeque<>();
        Queue<Integer> s = new ArrayDeque<>();
        for(int i=0; i<progresses.length; i++) {
            p.add(progresses[i]);
            s.add(speeds[i]);
        }
        while(!p.isEmpty()) {
            for(int i=0; i<p.size(); i++) {
                int pPoll = p.poll();
                int sPoll = s.poll();
                p.add(pPoll + sPoll);
                s.add(sPoll);
            }
            if(p.peek() >= 100) {
                int count = 1;
                p.poll();
                s.poll();
                int size = p.size();
                for(int i=0; i<size; i++) {
                    if(p.peek() >= 100) {
                        p.poll();
                        s.poll();
                        count++;
                    }
                }
                answer.add(count);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}