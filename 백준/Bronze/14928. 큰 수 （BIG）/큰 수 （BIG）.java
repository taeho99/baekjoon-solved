import java.math.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        long temp = 0;
        for (int i = 0; i < s.length(); i++) {
            temp = (temp * 10 + (s.charAt(i) - '0')) % 20000303;
        }
        System.out.print(temp);
    }
}
