import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int result = 0;
        int[] arr = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        while(n-- > 0) {
            int a = input.nextInt() - 1;
            int b = input.nextInt();
            if(arr[a] != -1 && arr[a] != b) {
                result++;
            }
            arr[a] = b;
        }
        System.out.println(result);
    }
}
