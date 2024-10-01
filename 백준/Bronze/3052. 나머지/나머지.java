import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] mod = new int[10];
        int count = 0;
        for(int i=0; i<10; i++) {
            mod[i] = input.nextInt() % 42;
            count++;
            for(int j=0; j<i; j++) {
                if(mod[i] == mod[j]) {
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
