import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(; ; n++) {
            if(isPrime(n) && isPalindrome(n)) {
                System.out.println(n);
                return;
            }
        }
    }

    static boolean isPalindrome(int n) {
        String word = String.valueOf(n);
        for(int i=0; i<word.length()/2; i++) {
            if(word.charAt(i) != word.charAt(word.length()-1-i))
                return false;
        }
        return true;
    }

    static boolean isPrime(int n) {
        if(n == 1) return false;
        for(int i=2; i<=Math.sqrt(n); i++)
            if(n%i == 0)
                return false;
        return true;
    }
}
