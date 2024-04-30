import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt(), y1 = sc.nextInt();
        int x2 = sc.nextInt(), y2 = sc.nextInt();
        int x3 = sc.nextInt(), y3 = sc.nextInt();

        int x, y;
        if(x1 == x2)
            x = x3;
        else if (x2 == x3)
            x = x1;
        else x = x2;

        if(y1 == y2)
            y = y3;
        else if (y2 == y3)
            y = y1;
        else y = y2;
        System.out.println(x + " " + y);
    }
}
