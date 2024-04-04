import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int min = 1000001, max = 0;
        for(int i=0; i<n; i++) {
            int tmp = input.nextInt();
            if(tmp < min) {
                min = tmp;
            }
            if(tmp > max) {
                max = tmp;
            }
        }
        System.out.println(max*min);
    }
}
