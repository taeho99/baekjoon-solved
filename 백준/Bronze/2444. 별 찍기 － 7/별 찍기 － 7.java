import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        for (int i=0; i<n; i++) {
            for(int j=n-1; j>i; j--) {
                System.out.print(" ");
            }
            for(int j=0; j<2*i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i=n-2; i>=0; i--) {
            for(int j=n-1; j>i; j--) {
                System.out.print(" ");
            }
            for(int j=0; j<2*i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
