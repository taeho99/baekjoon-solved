import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt(); sc.nextLine();
        for(int t=1; t<=testCase; t++) {
            String s = sc.nextLine();
            char now = '0';
            int cnt = 0;
            for (char c : s.toCharArray()) {
                if(c != now) {
                    cnt++;
                    now = c;
                }
            }
            System.out.println("#" + t + " " + cnt);
        }
    }
}
