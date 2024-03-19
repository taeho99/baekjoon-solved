class Solution {
    public int solution(int n, int m, int[] section) {
        boolean[] isPaint = new boolean[n+1];
        for (int i : section) {
            isPaint[i] = true;
        }

        int answer = 0;

        for(int left=1; left<=n; left++) {
            if(isPaint[left]) {
                for(int j=left; j<left+m; j++) {
                    if(j <= n) {
                        isPaint[j] = true;
                    }
                }
                left += m - 1;
                answer++;
            }
        }
        return answer;
    }
}