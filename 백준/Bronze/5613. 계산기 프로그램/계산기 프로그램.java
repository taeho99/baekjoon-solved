import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        char cmd = '+';

        for(int i=0; ; i++) {
            String input = br.readLine();
            if(input.equals("=")) break;
            if(i%2 == 0) {
                switch(cmd) {
                    case '+':
                        result += Integer.parseInt(input);
                        break;
                    case '-':
                        result -= Integer.parseInt(input);
                        break;
                    case '*':
                        result *= Integer.parseInt(input);
                        break;
                    case '/':
                        result /= Integer.parseInt(input);
                        break;
                }
            } else {
                cmd = input.charAt(0);
            }
        }

        System.out.print(result);

    }
}