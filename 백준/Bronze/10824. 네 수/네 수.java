import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        for (int i=0; i<4; i++)
            arr[i] = sc.nextInt();
        System.out.print(Long.parseLong(""+arr[0]+arr[1])+Long.parseLong(""+arr[2]+arr[3]));
    }
}
