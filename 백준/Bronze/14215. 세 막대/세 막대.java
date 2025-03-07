import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] s = new int[3];
        s[0] = sc.nextInt(); s[1] = sc.nextInt(); s[2] = sc.nextInt();
        Arrays.sort(s);
        System.out.println(s[0]+s[1] > s[2] ? s[0]+s[1]+s[2] : (s[0]+s[1])*2 - 1);
    }
}
