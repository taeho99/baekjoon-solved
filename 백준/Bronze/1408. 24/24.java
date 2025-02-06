import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime now = LocalTime.parse(br.readLine(), formatter);
        LocalTime start = LocalTime.parse(br.readLine(), formatter);
        long seconds = Duration.between(now, start).getSeconds();
        if (now.isAfter(start)) {
            seconds = (60 * 60 * 24) + seconds;
        }
        long hour = seconds / 3600;
        seconds %= 3600;
        long minute = seconds / 60;
        seconds %= 60;
        System.out.printf("%02d:%02d:%02d", hour, minute, seconds);
    }
}