import java.util.*;
class Main {
    public static void main(String[]a) {
        Scanner sc=new Scanner(System.in);
        String s;
        while(!(s = sc.next()).equals("0")) {
            System.out.println(s.contentEquals(new StringBuffer(s).reverse())?"yes":"no");
        }
    }
}
