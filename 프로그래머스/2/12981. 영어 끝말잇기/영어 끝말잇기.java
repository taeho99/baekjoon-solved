import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] seq = new int[n];
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<words.length; i++) {
            seq[i%n]++;
            if(i != 0 && (words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1))) {
                return new int[] {(i%n) + 1, seq[i%n]};
            }
            if(set.contains(words[i])) {
                return new int[] {(i%n) + 1, seq[i%n]};
            }
            set.add(words[i]);
        }
        return new int[] {0, 0};
    }
}