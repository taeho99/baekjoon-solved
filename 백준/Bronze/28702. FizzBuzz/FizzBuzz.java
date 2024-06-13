import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lastValue = 0;
        int lastIndex = 0;

        for(int i=3; i>0; i--) {
            String s = br.readLine();
            try {
                lastValue = Integer.parseInt(s);
                lastIndex = i;
            } catch (NumberFormatException ignored) {}
        }
        lastValue += lastIndex;
        if(lastValue%3==0 && lastValue%5==0)
            System.out.println("FizzBuzz");
        else if(lastValue%3 == 0)
            System.out.println("Fizz");
        else if(lastValue%5 == 0)
            System.out.println("Buzz");
        else
            System.out.println(lastValue);
    }
}
