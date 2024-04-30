import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);
        while(m-- > 0) {
            int i = sc.nextInt()-1;
            int j = sc.nextInt();
            List<Integer> temp = new ArrayList<>(list.subList(0, i));
            List<Integer> temp2 = list.subList(i, j);
            Collections.reverse(temp2);
            temp.addAll(temp2);
            temp.addAll(list.subList(j, list.size()));
            list = temp;
        }
        list.forEach(i -> System.out.print(i + " "));
    }
}
