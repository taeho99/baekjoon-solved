import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        HashSet<Character> set = new HashSet<>();
        for(int idx=0; idx<n; idx++) {
            String[] words = br.readLine().split(" ");
            int shortcutIdx = -1;
            String shortcutWord = null;
            for (String word : words) {
                char firstLetter = Character.toUpperCase(word.charAt(0));
                if (!set.contains(firstLetter)) {
                    set.add(firstLetter);
                    shortcutIdx = 0;
                    shortcutWord = word;
                    break;
                }
            }

            if(shortcutWord == null) {
                for (String word : words) {
                    for (int ch=0; ch<word.length(); ch++) {
                        char letter = Character.toUpperCase(word.charAt(ch));
                        if(!set.contains(letter)) {
                            set.add(letter);
                            shortcutIdx = ch;
                            shortcutWord = word;
                            break;
                        }
                    }
                    if(shortcutWord != null) break;
                }
            }

            boolean check = false;
            for (String word : words) {
                for (int ch=0; ch<word.length(); ch++) {
                    char c = word.charAt(ch);
                    if (!check && word.equals(shortcutWord) && ch == shortcutIdx) {
                        sb.append('[').append(c).append(']');
                        check = true;
                    } else {
                        sb.append(c);
                    }
                }
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}