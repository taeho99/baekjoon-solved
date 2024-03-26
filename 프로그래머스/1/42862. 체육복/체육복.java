import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> reserveSet = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();
        for (int i : reserve) {
            reserveSet.add(i);
        }
        for (int i : lost) {
            if(!reserveSet.remove(i)) {
                lostSet.add(i);
            }
        }
        for (Integer i : reserveSet) {
            if(!lostSet.remove(i-1)) {
                lostSet.remove(i+1);
            }
        }
        return n - lostSet.size();
    }
}