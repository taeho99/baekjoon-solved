import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        //프로세스 대기 큐 초기화
        Queue<Process> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            queue.add(new Process(i, priorities[i]));
        }

        //실행횟수 초기화
        int count = 0;

        while(!queue.isEmpty()) {
            //실행하려고 하는 프로세스 poll
            Process poll = queue.poll();
            //우선순위가 높은 프로세스가 큐에 있는가?
            boolean isBig = false;

            for (Process p : queue) {
                //우선순위가 높은 프로세스가 큐에 있을 경우
                if(p.priority > poll.priority) {
                    queue.add(poll); //큐 맨 뒤에 현재 프로세스 추가
                    isBig = true;
                    break;
                }
            }

            //프로세스가 정상적으로 실행된 경우
            if(!isBig) {
                //실행횟수를 +1 한다
                count++;
                //현재 프로세스가 location과 같은 경우 answer에 실행횟수를 넣고 while문 중단
                if (poll.num == location) {
                    answer = count;
                    break;
                }
            }
        }
        return answer;
    }

    static class Process {
        int num, priority;

        public Process(int num, int priority) {
            this.num = num;
            this.priority = priority;
        }
    }
}