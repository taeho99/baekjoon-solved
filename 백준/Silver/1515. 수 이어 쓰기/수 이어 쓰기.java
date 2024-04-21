import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        int pointer = 0, base = 0;
        while(base++ <= 30000) {
            String tmp = String.valueOf(base);
            for(int i=0; i<tmp.length(); i++) {
                if(tmp.charAt(i) == s.charAt(pointer)) {
                    pointer++;
                }
                if(pointer == s.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}
