import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while(t-- > 0) {
            long a = input.nextInt();
            long b = input.nextInt();
            for(int i=1; ; i++) {
                if(b*i % a == 0) {
                    System.out.println(b*i);
                    break;
                }
            }
        }
    }
}
