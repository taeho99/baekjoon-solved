class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int result = 0;
        for(int row=0; row<schedules.length; row++) {
            schedules[row] += 10;
            if (schedules[row] % 100 >= 60) {
                schedules[row] += 40;
            }
        }
        
        startday--;
        for(int row=0; row<timelogs.length; row++) {
            boolean isSuccess = true;
            for(int col=0; col<timelogs[0].length; col++) {
                int day = (col + startday) % 7;
                if (day == 5 || day == 6) continue;
                if (timelogs[row][col] > schedules[row]) {
                    isSuccess = false;
                    break;
                }
            }
            
            if (isSuccess) result++;
        }
        
        return result;
    }
}