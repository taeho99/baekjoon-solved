import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int n = score.length;
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
            list.add(score[i]);
            Collections.sort(list);
            if(i<k) {
                answer[i] = list.get(0);
            } else {
                answer[i] = list.get(i-k+1);
            }
        }
        return answer;
    }
}