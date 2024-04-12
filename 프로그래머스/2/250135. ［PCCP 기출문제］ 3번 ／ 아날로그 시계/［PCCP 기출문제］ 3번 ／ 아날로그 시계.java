class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int result = 0;

        if(m1 == 0 && s1 == 0 && (h1 == 0 || h1 == 12)) {
            result++;
        }

        while(!(h1 == h2 && m1 == m2 && s1 == s2)) {
            double beforeH = gethAngle(h1, m1, s1);
            double beforeM = getmAngle(m1, s1);
            double beforeS = getsAngle(s1);

            s1++;
            if(s1 == 60) {
                m1++;
                s1 = 0;
                if(m1 == 60) {
                    h1++;
                    m1 = 0;
                }
            }

            double afterH = gethAngle(h1, m1, s1);
            double afterM = getmAngle(m1, s1);
            double afterS = getsAngle(s1);

//            System.out.println(beforeH + " " + beforeM + " " + beforeS);
//            System.out.println("[" + h1 + " " + m1 + " " + s1 + "]");
//            System.out.println(afterH + " " + afterM + " " + afterS);

            //
            if(beforeS < beforeM && afterM <= afterS && beforeS < beforeH && afterH <= afterS) {
                if(afterH == afterM) {
                    result++;
                } else {
                    result += 2;
                }
            } else if ((beforeS < beforeM && afterM <= afterS) || (beforeS == 354.0 && beforeM > 354.0)) {
//                System.out.println("[" + h1 + " " + m1 + " " + s1 + "]");
//                System.out.println(afterH + " " + afterM + " " + afterS);
                result++;
            } else if((beforeS < beforeH && afterH <= afterS) || (beforeS == 354.0 && beforeH > 354.0)) {
//                System.out.println("[" + h1 + " " + m1 + " " + s1 + "]");
//                System.out.println(afterH + " " + afterM + " " + afterS);
                result++;
            }
        }

        return result;

    }

    private double gethAngle(int h, int m, int s) {
        return (double) ((h%12) * 360) / 12 + (double) (m * 360) / 60 / 12 + (double) (s * 360) / 60 / 60 / 12;
    }

    private double getmAngle(int m, int s) {
        return (double) (m * 360) / 60 + (double) (s * 360) / 60 / 60;
    }

    private double getsAngle(int s) {
        return (double) (s * 360) / 60;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(11, 58, 59, 11, 59, 0));
    }

}
