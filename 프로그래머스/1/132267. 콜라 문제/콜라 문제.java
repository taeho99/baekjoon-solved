class Solution {
    public int solution(int a, int b, int n) {
        return backtracking(a, b, n);
    }

    int backtracking(int a, int b, int n) {
        if(n < a) {
            return 0;
        }
        int sum = n/a*b;
        return sum + backtracking(a, b, sum + n%a);
    }
}