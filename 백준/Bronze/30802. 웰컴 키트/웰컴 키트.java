import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] size = new int[6];
        for(int i=0; i<6; i++) {
            size[i] = sc.nextInt();
        }
        int t = sc.nextInt(), p = sc.nextInt();

        int result = 0;
        for(int i=0; i<6; i++) {
            result += (size[i]+t-1)/t;
        }
        System.out.println(result);
        System.out.println(n/p + " " + n%p);
    }
}
