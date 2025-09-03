class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0, maxHeight = 0;
        for(int idx=0; idx<sizes.length; idx++) {
            if(sizes[idx][0] < sizes[idx][1]) {
                int tmp = sizes[idx][0];
                sizes[idx][0] = sizes[idx][1];
                sizes[idx][1] = tmp;
            }
            maxWidth = Math.max(sizes[idx][0], maxWidth);
            maxHeight = Math.max(sizes[idx][1], maxHeight);
        }
        return maxWidth * maxHeight;
    }
}