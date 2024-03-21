class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n != 0) {
            sb.insert(0, n%k);
            n /= k;
        }
        int answer = 0;
        String[] split = sb.toString().split("0");
        for (String s : split) {
            if(s.isEmpty()) continue;
            long num = Long.parseLong(s);
            boolean isPrime = true;
            for(int i=2; i<((long)Math.sqrt(num)+1); i++) {
                if(num%i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime && num != 1) {
                answer++;
            }
        }

        return answer;
    }
}