import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        long sum = 0;
        int[] freq = new int[10];
        for (char c : s.toCharArray()) {
            freq[c - '0']++;
            sum += c - '0';
        }
        if(!s.contains("0") || sum%3 != 0) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            sb.append(String.valueOf(i).repeat(freq[i]));
        }
        System.out.println(sb);
    }
}
