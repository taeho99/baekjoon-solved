import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n = input.nextInt();
        int k = input.nextInt();
        for(int i=1; i<=n; i++) {
            if(n%i == 0)
                list.add(i);
        }
        System.out.println(list.size() < k ? 0 : list.get(k-1));
    }
}
