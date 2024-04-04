import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            queue.add(new Process(i, priorities[i]));
        }
        int time = 0;
        while(!queue.isEmpty()) {
            Process poll = queue.poll();
            boolean isBig = false;
            for (Process p : queue) {
                if(p.priority > poll.priority) {
                    queue.add(poll);
                    isBig = true;
                    break;
                }
            }
            if(isBig) continue;
            else time++;

            if(poll.num == location)
                return time;
        }
        return time;
    }

    static class Process {
        int num, priority;

        public Process(int num, int priority) {
            this.num = num;
            this.priority = priority;
        }
    }
}