import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Guitar> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(new Guitar(br.readLine()));
        }
        Collections.sort(list);
        for (Guitar guitar : list) {
            System.out.println(guitar.serial);
        }
    }

    static class Guitar implements Comparable<Guitar> {
        String serial;

        public Guitar(String serial) {
            this.serial = serial;
        }

        @Override
        public int compareTo(Guitar o) {
            if(this.serial.length() == o.serial.length()) {
                int left = 0, right = 0;
                for (char c : this.serial.toCharArray()) {
                    if (Character.isDigit(c))
                        left += c - '0';
                }
                for (char c : o.serial.toCharArray()) {
                    if(Character.isDigit(c))
                        right += c - '0';
                }
                if(left != right) {
                    return Integer.compare(left, right);
                } else {
                    return this.serial.compareTo(o.serial);
                }
            } else {
                return Integer.compare(this.serial.length(), o.serial.length());
            }
        }
    }
}
