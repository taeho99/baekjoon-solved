import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int people = input.nextInt() * input.nextInt();
        for(int i=0; i<5; i++) {
            System.out.print(input.nextInt() - people + " ");
        }
    }
}
