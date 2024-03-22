import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "0 0");
        map.put("2", "0 1");
        map.put("3", "0 2");
        map.put("4", "1 0");
        map.put("5", "1 1");
        map.put("6", "1 2");
        map.put("7", "2 0");
        map.put("8", "2 1");
        map.put("9", "2 2");
        map.put("*", "3 0");
        map.put("0", "3 1");
        map.put("#", "3 2");
        
        String left = map.get("*");
        String right = map.get("#");
        String result = "";
        
        for(int i=0; i<numbers.length; i++) {
            int now = numbers[i];
            String next;
            if (now == 1 || now == 4 || now == 7) {
                left = map.get(String.valueOf(now));
                result += "L";
            } else if (now == 3 || now == 6 || now == 9) {
                right = map.get(String.valueOf(now));
                result += "R";
            } else {
                int leftY = Integer.parseInt(left.split(" ")[0]);
                int leftX = Integer.parseInt(left.split(" ")[1]);
                int rightY = Integer.parseInt(right.split(" ")[0]);
                int rightX = Integer.parseInt(right.split(" ")[1]);
                int nextY = Integer.parseInt(map.get(String.valueOf(now)).split(" ")[0]);
                int nextX = Integer.parseInt(map.get(String.valueOf(now)).split(" ")[1]);
                
                int leftDiff = Math.abs(leftY - nextY) + Math.abs(leftX - nextX);
                int rightDiff = Math.abs(rightY - nextY) + Math.abs(rightX - nextX);
                
                if(leftDiff < rightDiff) {
                    left = map.get(String.valueOf(now));
                    result += "L";
                } else if (leftDiff > rightDiff) {
                    right = map.get(String.valueOf(now));
                    result += "R";
                } else {
                    if(hand.equals("left")) {
                        left = map.get(String.valueOf(now));
                    } else {
                        right = map.get(String.valueOf(now));
                    }
                    result += hand.substring(0, 1).toUpperCase();
                }
            }
        }
        return result;
    }
}