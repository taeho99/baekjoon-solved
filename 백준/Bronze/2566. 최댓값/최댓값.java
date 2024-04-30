import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y=0, x=0;
        int max = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                int n = sc.nextInt();
                if (n >= max) {
                    max = n;
                    y = i;
                    x = j;
                }
            }
        }
        System.out.println(max);
        System.out.println(y + " " + x);
    }
}
