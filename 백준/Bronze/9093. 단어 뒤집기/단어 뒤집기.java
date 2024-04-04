import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(input.nextLine());
        while(t-- > 0) {
            String s = input.nextLine();
            String[] words = s.split(" ");
            for (String word : words) {
                for(int i=word.length() - 1; i>=0; i--)
                    sb.append(word.charAt(i));
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
