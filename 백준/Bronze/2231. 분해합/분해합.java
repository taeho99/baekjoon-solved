import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++) {
            int tmp = i;
            String s = String.valueOf(i);
            for (char c : s.toCharArray()) {
                tmp += c - '0';
            }
            if(tmp == n) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
