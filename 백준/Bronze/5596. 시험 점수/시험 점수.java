import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = 0, t = 0;
        for(int i=0; i<4; i++)
            s += sc.nextInt();
        for(int i=0; i<4; i++)
            t += sc.nextInt();
        System.out.print(Math.max(s, t));
    }
}
