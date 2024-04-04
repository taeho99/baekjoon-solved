import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        int[] arr = new int[26];
        for(int i=0; i<26; i++)
            arr[i] = -1;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(arr[c - 'a'] == -1)
                arr[c - 'a'] = i;
        }
        for(int i=0; i<26; i++)
            System.out.print(arr[i] + " ");
    }
}
