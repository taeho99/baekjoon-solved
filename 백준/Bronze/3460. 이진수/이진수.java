import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while(t-- > 0) {
            String bin = Integer.toBinaryString(input.nextInt());
            for(int i=bin.length()-1; i>=0; i--)
                if(bin.charAt(i) == '1')
                    System.out.print(bin.length() - i - 1 + " ");
            System.out.println();
        }
    }
}
