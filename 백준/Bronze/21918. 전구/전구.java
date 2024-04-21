import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        boolean[] arr = new boolean[n+1];
        for(int i=1; i<=n; i++)
            arr[i] = input.nextInt() == 1;
        while(m-- > 0) {
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            if (a == 1) {
                arr[b] = c == 1;
            } else if (a == 2) {
                for(int i=b; i<=c; i++) arr[i] = !arr[i];
            } else if (a == 3) {
                for(int i=b; i<=c; i++) arr[i] = false;
            } else {
                for(int i=b; i<=c; i++) arr[i] = true;
            }
        }
        for(int i=1; i<=n; i++)
            System.out.print((arr[i] ? 1 : 0) + " ");
    }
}
