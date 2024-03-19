class Solution {
    public int solution(String dartResult) {
        int[] score = new int[3];
        int now = -1;
        for(int i=0; i<dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if('0' <= c && c <= '9') {
                now++;
                if(c == '1' && dartResult.charAt(i+1) == '0') {
                    score[now] = 10;
                    i++;
                } else {
                    score[now] = c - '0';
                }
            } else if (c == 'S') {
                score[now] = (int) Math.pow(score[now], 1);
            } else if (c == 'D') {
                score[now] = (int) Math.pow(score[now], 2);
            } else if (c == 'T') {
                score[now] = (int) Math.pow(score[now], 3);
            } else if (c == '*') {
                score[now] *= 2;
                if(now != 0) {
                    score[now-1] *= 2;
                }
            } else if (c == '#') {
                score[now] *= -1;
            }
        }
        return score[0] + score[1] + score[2];
    }
}