import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = input.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(arr[n-k]);
    }
}
