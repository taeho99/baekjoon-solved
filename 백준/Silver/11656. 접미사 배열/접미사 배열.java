import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            list.add(s.substring(i));
        }
        list.stream().sorted().forEach(System.out::println);
    }
}
