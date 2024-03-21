import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> time = new HashMap<>();
        HashMap<String, Integer> lastIn = new HashMap<>();
        HashSet<String> isIn = new HashSet<>();
        HashMap<String, Integer> result = new HashMap<>();
        for (String record : records) {
            String[] split = record.split(" ");
            int hour = Integer.parseInt(split[0].split(":")[0]);
            int minute = Integer.parseInt(split[0].split(":")[1]);
            String number = split[1];
            String inout = split[2];

            int timeToInt = hour*60 + minute;

            System.out.println("[" + inout + "] " + number + ", " + timeToInt);

            if(inout.equals("IN")) {
                lastIn.put(number, timeToInt);
                isIn.add(number);
            } else {
                int diff = timeToInt - lastIn.get(number);
                time.put(number, time.getOrDefault(number, 0) + diff);
                isIn.remove(number);
            }
        }

        for (String number : isIn) {
            int outTime = 23*60 + 59;
            int diff = outTime - lastIn.get(number);
            time.put(number, time.getOrDefault(number, 0) + diff);
        }

        List<Car> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : time.entrySet()) {
            String number = entry.getKey();
            int nowTime = entry.getValue();
            int price = fees[1];
            if (nowTime > fees[0]) {
                price += (int) (Math.ceil((double) (nowTime - fees[0]) / fees[2]) * fees[3]);
            }
            answer.add(new Car(number, price));
        }

        answer.sort(Comparator.comparing(o -> o.number));

        return answer.stream().mapToInt(i -> i.price).toArray();
    }

    class Car {
        String number;
        int price;

        public Car(String number, int price) {
            this.number = number;
            this.price = price;
        }
    }
}