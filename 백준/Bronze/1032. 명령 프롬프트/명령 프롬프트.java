import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = Integer.parseInt(input.nextLine());
        String result = input.nextLine();
        StringBuilder sb = new StringBuilder(result);

        for(int i=1; i<T; i++) {
            String str = input.nextLine();
            for(int j=0; j<str.length(); j++) {
                if (result.charAt(j) != str.charAt(j)) {
                    sb.setCharAt(j, '?');
                    result = sb.toString();
                }
            }
        }

        System.out.println(result);
    }
}
