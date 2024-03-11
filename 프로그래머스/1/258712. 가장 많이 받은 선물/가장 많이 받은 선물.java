import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {

        Map<String, Integer> giftPoints = new HashMap<>();
        Map<String, Map<String, Integer>> history = new HashMap<>();
        Map<String, Integer> giveCount = new HashMap<>();
        Map<String, Integer> takeCount = new HashMap<>();
        Map<String, Integer> answer = new HashMap<>();

        for (String friend : friends) {
            history.put(friend, new HashMap<>());
            giveCount.put(friend, 0);
            takeCount.put(friend, 0);
            answer.put(friend, 0);
        }

        for(int i=0; i<friends.length; i++) {
            for(int j=0; j<friends.length; j++) {
                if(i == j) continue;
                history.get(friends[i]).put(friends[j], 0);
            }
        }

        for (String gift : gifts) {
            StringTokenizer st = new StringTokenizer(gift);
            String giver = st.nextToken();
            String taker = st.nextToken();

            history.get(giver).compute(taker, (s, i) -> i+1);

            giveCount.compute(giver, (s, i) -> i + 1);
            takeCount.compute(taker, (s, i) -> i + 1);
        }

        for (String friend : friends) {
            Integer gives = giveCount.get(friend);
            Integer takes = takeCount.get(friend);
            giftPoints.put(friend, gives - takes);
        }

        for (String s : history.keySet()) {
            System.out.println("---------------------------");
            System.out.println("giver name: " + s);
            Map<String, Integer> stringIntegerMap = history.get(s);
            for (String string : stringIntegerMap.keySet()) {
                System.out.print("[" + string + ", " + stringIntegerMap.get(string) + "], ");
            }
            System.out.println();
        }

        for (String s : giftPoints.keySet()) {
            System.out.println("---------------------------");
            System.out.println("name: " + s + ", point: " + giftPoints.get(s));
        }

        for(int i=0; i<friends.length; i++) {
            for(int j=i+1; j<friends.length; j++) {
                String a = friends[i];
                String b = friends[j];

                //a->b 준 선물 수
                Integer aToB = history.get(a).get(b);
                //b->a 준 선물 수
                Integer bToA = history.get(b).get(a);

                //a가 준 선물이 더 많을 시
                if (aToB > bToA) {
                    answer.compute(a, (s, count) -> count + 1);
                } else if (aToB < bToA) {
                    answer.compute(b, (s, count) -> count + 1);
                } else {
                    if(giftPoints.get(a) > giftPoints.get(b)) {
                        answer.compute(a, (s, count) -> count + 1);
                    } else if(giftPoints.get(a) < giftPoints.get(b)) {
                        answer.compute(b, (s, count) -> count + 1);
                    }
                }
            }
        }

        for (String s : answer.keySet()) {
            System.out.println("---------------------------");
            System.out.println("name: " + s + ", result: " + answer.get(s));
        }

        int max = 0;
        for (int value : answer.values()) {
            max = Math.max(max, value);
        }

        return max;
    }
}