import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for(int l=0; l<commands.length; l++) {
            int i = commands[l][0]-1;
            int j = commands[l][1]-1;
            int k = commands[l][2]-1;
            List<Integer> list = new ArrayList<>();
            for(int m=i; m<=j; m++) {
                list.add(array[m]);
            }
            Collections.sort(list);
            answer.add(list.get(k));
        }
        return answer;
    }
}