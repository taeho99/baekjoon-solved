import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int[][] arr = {
            {1}, {2,4,8,6}, {3,9,7,1}, {4,6}, {5},
            {6}, {7,9,3,1}, {8,4,2,6}, {9,1}, {10}
        };

        int T = input.nextInt();
        for(int i=0; i<T; i++) {
            int a = input.nextInt();
            int b = input.nextInt();

            a %= 10;
            if (a == 0)
                a = 10;

            if (a == 1 || a == 5 || a == 6 || a == 10) {
                System.out.println(arr[a - 1][0]);
            } else if (a == 2 || a == 3 || a == 7 || a == 8) {
                System.out.println(arr[a-1][(b-1)%4]);
            } else if (a == 4 || a == 9) {
                System.out.println(arr[a-1][(b-1)%2]);
            }
        }
    }
}
