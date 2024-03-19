class Solution
{
    public int solution(int n, int a, int b)
    {
        int round=0;
        int a_idx = n+a-1;
        int b_idx = n+b-1;
        while(a_idx != b_idx) {
            a_idx /= 2;
            b_idx /= 2;
            round++;
        }

        return round;
    }
}