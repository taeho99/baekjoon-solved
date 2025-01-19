import java.util.*;

class Solution {
    public List<Integer> solution(int n, long left, long right) {
        ArrayList<Integer> list = new ArrayList<>();
        for(long idx=left; idx<=right; idx++) {
            list.add(Math.max((int)(idx/n), (int)(idx%n))+1);
        }
        return list;
    }
}