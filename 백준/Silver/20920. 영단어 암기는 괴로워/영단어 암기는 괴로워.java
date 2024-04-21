import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            if(s.length() >= m) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        List<Word> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Word(entry.getKey(), entry.getValue()));
        }

        list.sort((o1, o2) -> {
            if(o1.count == o2.count) {
                if(o1.word.length() == o2.word.length()) {
                    return o1.word.compareTo(o2.word);
                }
                return Integer.compare(o2.word.length(), o1.word.length());
            }
            return Integer.compare(o2.count, o1.count);
        });

        for (Word w : list) {
            sb.append(w.word).append('\n');
        }
        System.out.print(sb);
    }

    static class Word {
        String word;
        int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
