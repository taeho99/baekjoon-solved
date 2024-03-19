import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> parent = new HashMap<>();
        HashMap<String, Integer> total = new HashMap<>();

        for(int i=0; i<enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
            total.put(enroll[i], 0);
        }

        for(int i=0; i<seller.length; i++) {
            String name = seller[i];
            int price = amount[i] * 100;
            total.put(name, total.get(name) + (int) (price * 0.9));
            String parentName = parent.get(name);

            while(!parentName.equals("-")) {
                price = (int) (Math.floor(price*0.1));
                if(price == 0) break;
                total.put(parentName, total.get(parentName) + (int) (Math.ceil(price * 0.9)));
                parentName = parent.get(parentName);
            }
        }

        int[] answer = new int[enroll.length];
        for(int i=0; i<answer.length; i++) {
            answer[i] = total.get(enroll[i]);
        }
        return answer;
    }
}