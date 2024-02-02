import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        int[] a = new int[n];
        int[] s = new int[n+1];
        for(int i=0; i<n; i++) {
            a[i] = input.nextInt();
            s[i+1] = s[i] + a[i];
        }

        while((m--) > 0) {
            int i = input.nextInt();
            int j = input.nextInt();
            System.out.println(s[j] - s[i-1]);
        }
    }
}
