import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int result = 0;
        int T = input.nextInt();
        for(int i=0; i<T; i++) {
            String str = input.next();
            boolean[] flag = new boolean['z' - 'a' + 1];
            boolean isGroup = true;
            for(int j=0; j<str.length(); j++) {
                if (j != 0 && flag[str.charAt(j) - 'a'] && str.charAt(j) != str.charAt(j-1)) {
                    isGroup = false;
                    break;
                }
                flag[str.charAt(j) - 'a'] = true;
            }
            if (isGroup) result++;
        }

        System.out.println(result);
    }
}
