import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = input.nextInt();
        int n = input.nextInt();
        for(int i = 0; i<n; i++) {
            sum -= input.nextInt() * input.nextInt();
        }
        System.out.println(sum == 0 ? "Yes" : "No");
    }
}