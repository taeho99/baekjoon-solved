import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        long s = input.nextLong();
        long sum = 0;
        int result = 0;
        for(int i=1; ; i++) {
            if (sum > s) break;
            sum += i;
            result++;
        }
        System.out.println(--result);
    }
}
