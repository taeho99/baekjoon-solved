import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);

        int count = 0;
        for(int i=2; i<=n; i++) {
            for(int j=i; j<=n; j+=i) {
                if(!arr[j]) continue;
                arr[j] = false;
                count++;
                if(count==k) System.out.println(j);
            }
        }
    }
}
