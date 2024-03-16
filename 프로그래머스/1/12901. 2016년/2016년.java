class Solution {
    public String solution(int a, int b) {
        int[] monthList = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayList = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int totalDay = 0;
        for(int i=0; i<a-1; i++) {
            totalDay += monthList[i];
        }
        totalDay += b - 1;
        return dayList[totalDay % 7];
    }
}