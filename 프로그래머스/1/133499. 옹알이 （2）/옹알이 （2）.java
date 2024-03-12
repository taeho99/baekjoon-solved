class Solution {
    public int solution(String[] babbling) {
        int count = 0;
        String[] prev_word = new String[babbling.length];
        for (int i=0; i< babbling.length; i++) {
            int j;
            for(j=0; j<babbling[i].length(); j++) {
                String s2 = "";
                if (j+2 <= babbling[i].length()) {
                    s2 = babbling[i].substring(j, j + 2);
                }
                String s3 = "";
                if (j+3 <= babbling[i].length()) {
                    s3 = babbling[i].substring(j, j + 3);
                }
                if(s2.equals(prev_word[i]) || s3.equals(prev_word[i])) {
                    break;
                }
                if(s2.equals("ye") || s2.equals("ma")) {
                    j++;
                    prev_word[i] = s2;
                } else if (s3.equals("aya") || s3.equals("woo")) {
                    j += 2;
                    prev_word[i] = s3;
                } else {
                    break;
                }
            }

            if (j == babbling[i].length()) {
                count++;
            }
        }
        return count;
    }
}