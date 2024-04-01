import java.util.Collections;
import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();

        Collections.addAll(set, phone_book);

        for (String s : phone_book) {
            for(int i=0; i<s.length(); i++) {
                if(set.contains(s.substring(0, i)))
                    return false;
            }
        }
        return true;
    }
}