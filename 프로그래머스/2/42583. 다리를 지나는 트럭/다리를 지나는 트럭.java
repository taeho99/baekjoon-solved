import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int nowBridgeWeight = 0;
        int time = 0;

        for (int truckWeight : truck_weights) {
            while(true) {
                //다리 위에 트럭이 없을 때
                if(queue.isEmpty()) {
                    queue.add(truckWeight);
                    nowBridgeWeight += truckWeight;
                    time++;
                    break;
                }
                //다리 위에 트럭이 있을 때
                else {
                    //건너는 중인 트럭의 수(큐 크기)와 다리의 길이가 같은 경우
                    if(queue.size() == bridge_length) {
                        nowBridgeWeight -= queue.poll();
                    }
                    //(건너는 중인 트럭의 무게 + 다음 트럭의 무게 > 다리 최대 무게)인 경우
                    else if(nowBridgeWeight + truckWeight > weight) {
                        queue.add(0);
                        time++;
                    }
                    //다음 트럭이 다리 최대 무게 이내인 경우
                    else {
                        queue.add(truckWeight);
                        nowBridgeWeight += truckWeight;
                        time++;
                        break;
                    }
                }
            }
        }

        //마지막이 트럭이 올라간 시점에 반복문이 종료되므로
        //이때까지 걸린 시간 + 마지막 트럭이 통과하는데 걸리는 시간(다리 길이)를 반환
        return time + bridge_length;
    }
}