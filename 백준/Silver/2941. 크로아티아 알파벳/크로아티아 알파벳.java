import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int result = 0;

        for(int i=0; i<s.length(); i++) {
            if (i != s.length() - 1) {
                switch (s.charAt(i)) {
                    case 'c':
                        if (s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-')
                            i++;
                        break;
                    case 'd':
                        if ((i != s.length() - 2) && (s.charAt(i + 1) == 'z' && s.charAt(i + 2) == '='))
                            i += 2;
                        else if (s.charAt(i + 1) == '-')
                            i++;
                        break;
                    case 'l':
                    case 'n':
                        if (s.charAt(i + 1) == 'j')
                            i++;
                        break;
                    case 's':
                    case 'z':
                        if (s.charAt(i + 1) == '=')
                            i++;
                        break;
                }
            }
            result++;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
