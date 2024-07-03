import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] freq = new int[26];
        String result = "";
        while(n-- > 0)
            freq[sc.nextLine().charAt(0) - 'a']++;
        for(int i=0; i<freq.length; i++)
            if(freq[i] >= 5) result += (char)('a' + i);
        System.out.print(result.isEmpty() ? "PREDAJA" : result);
    }
}
