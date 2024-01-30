import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] arr = br.readLine().toCharArray();
        Character[] arr2 = new Character[arr.length];

        for(int i=0; i<arr.length; i++) {
            arr2[i] = arr[i];
        }

        Arrays.sort(arr2, Collections.reverseOrder());

        for (char c : arr2) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}
