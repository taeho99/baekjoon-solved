import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if(n == 1) return;
        int div = 2;
        while(n != 1) {
            if(n%div != 0) {
                div++;
                continue;
            }
            System.out.println(div);
            n /= div;
        }
    }
}
