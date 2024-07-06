import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ja1 = sc.nextInt();
        int mo1 = sc.nextInt();
        int ja2 = sc.nextInt();
        int mo2 = sc.nextInt();

        int ja3 = ja1 * mo2 + ja2 * mo1;
        int mo3 = mo1 * mo2;

        int gcd = gcd(ja3, mo3);

        System.out.println(ja3/gcd + " " + mo3/gcd);
    }

    static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p%q);
    }
}
