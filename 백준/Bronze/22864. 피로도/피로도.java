import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt(), b = input.nextInt(), c = input.nextInt(), m = input.nextInt();
        int piro = 0, result = 0;
        for(int i=0; i<24; i++) {
            if(piro + a <= m) {
                piro += a;
                result += b;
            } else {
                if(piro - c < 0)
                    piro = 0;
                else 
                    piro -= c;
            }
        }
        System.out.println(result);
    }
}
