import java.util.Arrays;

class Solution {

    public int solution(int n) {
        int answer = 0;
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        for(int i=2; i*i<=n; i++) {
            if(isPrime[i]) {
                for(int j=i*i; j<=n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int i=2; i<=n; i++) {
            answer += isPrime[i] ? 1 : 0;
        }
        return answer;
    }
}