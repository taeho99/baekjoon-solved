class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        int div = x;
        int sum = 0;
        while(x > 0) {
            sum += x % 10;
            x /= 10;
        }
        if (div % sum == 0) {
            answer = true;
        }
        return answer;
    }
}