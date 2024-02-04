import java.util.Scanner;

public class Main {
    static int[] require;
    static int[] now;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int s = input.nextInt();
        int p = input.nextInt();
        char[] dna = input.next().toCharArray();
        require = new int[4];
        now = new int[20];
        for(int i=0; i<4; i++) {
            require[i] = input.nextInt();
        }

        int result = 0;
        for(int i = 0; i < p; i++) {
            now[dna[i] - 'A']++;
        }
        if (check()) result++;
        for(int i = p; i < s; i++) {
            now[dna[i - p] - 'A']--;
            now[dna[i] - 'A']++;
            if (check()) result++;
        }
        System.out.println(result);
    }

    static boolean check() {
        return now[0] >= require[0] && now[2] >= require[1] && now[6] >= require[2] && now[19] >= require[3];
    }
}