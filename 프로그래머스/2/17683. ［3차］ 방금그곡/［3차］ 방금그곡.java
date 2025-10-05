class Solution {
    StringBuilder sb;
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;
        m = convertMelody(m);
        for(String musicInfo : musicinfos) {
            String[] data = musicInfo.split(",");
            String start = data[0];
            String end = data[1];
            String name = data[2];
            String melody = convertMelody(data[3]);
            
            int playTime = getPlayTime(start, end);
            
            sb = new StringBuilder();
            for(int t=0; t<playTime; t++) {
                sb.append(melody.charAt(t%melody.length()));
            }
            
            if (sb.toString().contains(m) && playTime > maxPlayTime) {
                maxPlayTime = playTime;
                answer = name;
            }
        }
        return answer;
    }
    
    int getPlayTime(String start, String end) {
        String[] startTime = start.split(":");
        String[] endTime = end.split(":");
        
        int startHour = Integer.parseInt(startTime[0]);
        int startMinute = Integer.parseInt(startTime[1]);
        
        int endHour = Integer.parseInt(endTime[0]);
        int endMinute = Integer.parseInt(endTime[1]);
        
        return (endMinute - startMinute) + (60 * (endHour - startHour));
    }
    
    String convertMelody(String original) {
        return original.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a").replace("E#", "e").replace("B#", "b");
    }
}