import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int testCase = sc.nextInt();
        for(int t=1; t<=testCase; t++) {
            sb.append('#').append(t).append(' ');
            int N = sc.nextInt();
            StringBuilder tmp = new StringBuilder();
            for(int idx=0; idx<N; idx++) {
                tmp.append(sc.nextInt());
            }
            String str = tmp.toString();

            for(int result=0; ; result++) {
                if(!str.contains("" + result)) {
                    sb.append(result).append('\n');
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}
