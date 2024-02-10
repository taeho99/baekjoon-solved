import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = Color.valueOf(br.readLine()).number;
        String s2 = Color.valueOf(br.readLine()).number;
        String s3 = Color.valueOf(br.readLine()).zero;

        String value = s1 + s2;
        if (value.equals("00")) {
            System.out.println("0");
        } else {
            System.out.println(Integer.parseInt(value) + s3);
        }
    }

    public enum Color {
        black("0"),
        brown("1"),
        red("2"),
        orange("3"),
        yellow("4"),
        green("5"),
        blue("6"),
        violet("7"),
        grey("8"),
        white("9");

        private final String number;
        private String zero = "";

        Color(String number) {
            this.number = number;
            for(int i=0; i<Integer.parseInt(number); i++) {
                this.zero += "0";
            }
        }
    }
}
