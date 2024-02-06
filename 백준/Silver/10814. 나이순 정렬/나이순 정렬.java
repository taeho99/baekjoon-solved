import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        int seq = 0;

        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken(), ++seq));
        }
        Collections.sort(list);
        for (Person person : list) {
            System.out.println(person);
        }
    }

    static class Person implements Comparable<Person> {
        int age;
        String name;
        int seq;

        public Person(int age, String name, int seq) {
            this.age = age;
            this.name = name;
            this.seq = seq;
        }

        @Override
        public int compareTo(Person o) {
            if (this.age == o.age) return this.seq - o.seq;
            return this.age - o.age;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
}
