import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for(int i=0; i<queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        long goal = (sum1 + sum2)/2;
        int answer = 0, max = queue1.length*4;
        while(sum1 != sum2) {
            if(answer > max) return -1;
            if(sum1 > goal) {
                int poll = q1.poll();
                sum1 -= poll;
                sum2 += poll;
                q2.add(poll);
                answer++;
            } else {
                int poll = q2.poll();
                sum2 -= poll;
                sum1 += poll;
                q1.add(poll);
                answer++;
            }
        }

        return answer;
    }

}