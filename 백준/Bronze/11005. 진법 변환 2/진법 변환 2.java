import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        String string = Integer.toString(a, b);
        System.out.println(string.toUpperCase());
    }
}
