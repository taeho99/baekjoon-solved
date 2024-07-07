import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println(n * 78 / 100 + " " + ((n*4/5) + ((n/5*78/100))));
    }
}
