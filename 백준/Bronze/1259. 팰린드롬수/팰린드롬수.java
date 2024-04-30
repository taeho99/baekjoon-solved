import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        while(!(s = sc.next()).equals("0")) {
            System.out.println(s.equals(new StringBuilder().append(s).reverse().toString()) ? "yes" : "no");
        }
    }
}
