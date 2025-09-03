class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        for(int height = 3; height<=1250; height++) {
            for(int width = height; width<=2500; width++) {
                if((height-2)*(width-2) == yellow && (width+width+height+height-4) == brown)
                    return new int[] {width, height};
            }
        }
        return answer;
    }
}