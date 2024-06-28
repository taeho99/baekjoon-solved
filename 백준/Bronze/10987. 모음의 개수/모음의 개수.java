import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String s = new Scanner(System.in).next();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int sum = 0;
        for (char c : s.toCharArray()) {
            if(set.contains(c)) sum++;
        }
        System.out.println(sum);
    }
}
