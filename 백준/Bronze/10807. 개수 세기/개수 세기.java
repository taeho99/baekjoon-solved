import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        int[] arr = new int[T];

        for(int i=0; i<T; i++) {
            arr[i] = input.nextInt();
        }

        int correct = input.nextInt();
        int result = 0;

        for (int i : arr) {
            if (i == correct)
                result++;
        }

        System.out.println(result);
    }
}