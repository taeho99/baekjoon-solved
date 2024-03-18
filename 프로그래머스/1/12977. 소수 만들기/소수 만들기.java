import java.util.ArrayList;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(i+2 >= nums.length) break;
            for(int j=i+1; j<nums.length; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    list.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        for (int i : list) {
            int div = 2;
            answer++;
            while(div < i) {
                if(i % div == 0) {
                    answer--;
                    break;
                }
                div++;
            }
        }
        return answer;
    }
}