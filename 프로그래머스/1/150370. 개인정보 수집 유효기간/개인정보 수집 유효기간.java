import java.util.*;
class Solution {
    public int[] solution(String today, String[] termsList, String[] privacies) {
        int[] terms = new int[26];
        StringTokenizer st;
        for(String term : termsList) {
            st = new StringTokenizer(term);
            char alpha = st.nextToken().charAt(0);
            terms[alpha - 'A'] = Integer.parseInt(st.nextToken());
        }
        
        int todayNum = Integer.parseInt(today.replace(".", ""));
        
        List<Integer> result = new ArrayList<>();
        for(int idx=0; idx<privacies.length; idx++) {
            st = new StringTokenizer(privacies[idx]);
            String date = st.nextToken();
            
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(5, 7));
            int day = Integer.parseInt(date.substring(8, 10));
            
            int saveMonth = terms[st.nextToken().charAt(0) - 'A'];
            
            month += saveMonth;
            year += (month-1)/12;
            month = ((month-1)%12) + 1;
            
            day--;
            if(day == 0) {
                day = 28;
                month--;
            }
            if(month == 0) {
                month = 12;
                year--;
            }
            
            int sum = year * 10000 + month * 100 + day;
            
            if(todayNum > sum) result.add(idx+1);
        }
        int[] answer = new int[result.size()];
        for(int idx=0; idx<answer.length; idx++) {
            answer[idx] = result.get(idx);
        }
        return answer;
    }
}