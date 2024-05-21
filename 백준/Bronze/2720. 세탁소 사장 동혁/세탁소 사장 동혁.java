import java.util.Scanner;

public class Main {
    static int[] change = {25, 10, 5, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int money = sc.nextInt();
            for(int i=0; i<4; i++) {
                System.out.print(money/change[i] + " ");
                money%=change[i];
            }
            System.out.println();
        }
    }
}
