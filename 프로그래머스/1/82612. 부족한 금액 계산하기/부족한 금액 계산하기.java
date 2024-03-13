class Solution {
    public long solution(int price, int money, int count) {
        long answer = count*((long) price *(count+1))/2 - money;
        return answer > 0 ? answer : 0;
    }
}