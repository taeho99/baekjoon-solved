public class Solution {

    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] attack = new int[number+1];
        for(int i=1; i<=number; i++) {
            attack[i] = getYakCount(i);
        }
        for (int i : attack) {
            answer += i > limit ? power : i;
        }
        return answer;
    }

    private int getYakCount(int j) {
        int count = 1;
        for(int i=1; i<=j/2; i++) {
            if(j%i == 0) {
                count++;
            }
        }
        return count;
    }
}