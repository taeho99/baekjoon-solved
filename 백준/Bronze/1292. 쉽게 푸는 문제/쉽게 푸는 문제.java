import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=50; i++) {
            for(int j=1; j<=i; j++) {
                list.add(i);
            }
        }
        int a = input.nextInt();
        int b = input.nextInt();
        int sum = 0;
        for(int i=a; i<=b; i++) {
            sum += list.get(i-1);
        }
        System.out.println(sum);
    }
}
