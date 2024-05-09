import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int h = input.nextInt();
        int m = input.nextInt();
        int s = input.nextInt();
        int total = (h * 60 * 60 + m * 60 + s + input.nextInt()) % 86400;
        System.out.println(total / 60 / 60 + " " + total / 60 % 60 + " " + total % 60);
    }
}