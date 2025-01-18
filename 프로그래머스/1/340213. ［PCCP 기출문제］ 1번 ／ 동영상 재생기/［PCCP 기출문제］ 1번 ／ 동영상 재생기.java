import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int vl = timeToSecond(video_len);
        int p = timeToSecond(pos);
        int os = timeToSecond(op_start);
        int oe = timeToSecond(op_end);
        
        if(os <= p && p < oe) p = oe;
        
        for(String cmd : commands) {
            if(cmd.equals("next")) {
                p += 10;
                if(p > vl) p = vl;
            } else {
                p -= 10;
                if(p < 0) p = 0;
            }
            if(os <= p && p < oe) p = oe;
        }
        
        return String.format("%02d:%02d", p/60, p%60);
    }
    
    static int timeToSecond(String input) {
        StringTokenizer st = new StringTokenizer(input, ":");
        return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }
}