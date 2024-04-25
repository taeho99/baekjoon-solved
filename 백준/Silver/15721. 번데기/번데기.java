import java.util.Scanner;

public class Main {
    static int a, t, k;
    static int repeat = 2;
    static int zero, one;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        t = input.nextInt();
        k = input.nextInt();

        System.out.println(solve());
    }

    private static int solve() {
        while(true) {
            for(int i=0; i<4; i++) {
                if(i%2 == 0)
                    zero++;
                else
                    one++;
                if(k == 0 && zero == t)
                    return (zero+one-1)%a;
                if(k == 1 && one == t)
                    return (zero+one-1)%a;
            }
            for(int i=0; i<repeat; i++) {
                zero++;
                if(k == 0 && zero == t)
                    return (zero+one-1)%a;
            }
            for(int i=0; i<repeat; i++) {
                one++;
                if(k == 1 && one == t)
                    return (zero+one-1)%a;
            }
            repeat++;
        }
    }
}
