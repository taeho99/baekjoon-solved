import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(Character.isUpperCase(c))
                sb.append(String.valueOf(c).toLowerCase());
            else
                sb.append(String.valueOf(c).toUpperCase());
        }
        System.out.println(sb);
    }
}
