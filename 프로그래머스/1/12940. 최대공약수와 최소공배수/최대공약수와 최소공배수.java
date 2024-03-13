class Solution {
    public int[] solution(int n, int m) {
        if(n > m) {
            int tmp = n;
            n = m;
            m = tmp;
        }
        int[] answer = new int[2];
        for(int i=1; i<=n; i++) {
            if(m%i == 0 && n%i == 0) {
                answer[0] = i;
            }
        }
        answer[1] = n*m/answer[0];
        return answer;
    }
}