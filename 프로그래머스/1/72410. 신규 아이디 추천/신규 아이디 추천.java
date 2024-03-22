class Solution {
    public String solution(String new_id) {
        String sb1 = new_id.toLowerCase();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0; i<sb1.length(); i++) {
            char c = sb1.charAt(i);
            if (('a' <= c && c <= 'z') || ('0' <= c && c <= '9')
                    || c == '-' || c == '_' || c == '.') {
                sb2.append(c);
                continue;
            }
        }

        boolean isDot = false;
        StringBuilder sb3 = new StringBuilder();
        for(int i=0; i<sb2.length(); i++) {
            if(sb2.charAt(i) == '.') {
                if(!isDot) {
                    sb3.append('.');
                    isDot = true;
                } else {
                    isDot = true;
                }
            } else {
                sb3.append(sb2.charAt(i));
                isDot = false;
            }
        }

        System.out.println(sb3);

        while(sb3.length() != 0 && sb3.charAt(0) == '.') {
            sb3.deleteCharAt(0);
        }
        while(sb3.length() != 0 && sb3.charAt(sb3.length()-1) == '.') {
            sb3.deleteCharAt(sb3.length()-1);
        }
        if(sb3.length() == 0) {
            sb3.append('a');
        }
        StringBuilder sb6 = new StringBuilder(sb3.toString());
        if(sb6.length() >= 16) {
            sb6 = new StringBuilder(sb6.toString().substring(0, 15));
            while(sb6.charAt(sb6.length()-1) == '.') {
                sb6.deleteCharAt(sb6.length()-1);
            }
        }
        if(sb6.length() <= 2) {
            char last = sb6.charAt(sb6.length()-1);
            while(sb6.length() != 3) {
                sb6.append(last);
            }
        }

        return sb6.toString();
    }
}