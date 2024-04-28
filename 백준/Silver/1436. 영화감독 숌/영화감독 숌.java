import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int count = 1;
        int num = 666;
        while(count != n) {
            num++;
            if(String.valueOf(num).contains("666"))
                count++;
        }
        System.out.println(num);
    }
}
