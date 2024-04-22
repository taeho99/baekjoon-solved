import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++) {
            arr[i] = input.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        for(int i=n; i>=1; i--) {
            list.add(arr[i], i);
        }
        list.forEach(o -> System.out.print(o + " "));
    }
}
