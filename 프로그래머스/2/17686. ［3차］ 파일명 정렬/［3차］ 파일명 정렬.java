import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        int order = 0;
        for (String file : files) {
            int i;
            for(i=0; i<file.length(); i++) {
                char c = file.charAt(i);
                if(Character.isDigit(c)) {
                   break;
                }
            }
            int j;
            for(j=i; j<i+5; j++) {
                if(j == file.length()) break;
                char c = file.charAt(j);
                if(!Character.isDigit(c)) {
                    break;
                }
            }
            String head = file.substring(0, i);
            String number = file.substring(i, j);
            String tail = file.substring(j);

            list.add(new File(order++, number, head, tail));
        }

        Collections.sort(list);

        String[] answer = new String[list.size()];

        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i).toString();
        }

        return answer;
    }

    class File implements Comparable<File> {
        int order;
        String head, number, tail;

        public File(int order, String number, String head, String tail) {
            this.order = order;
            this.number = number;
            this.head = head;
            this.tail = tail;
        }

        @Override
        public int compareTo(File o) {
            if(this.head.equalsIgnoreCase(o.head)) {
                int thisNum = Integer.parseInt(this.number);
                int oNum = Integer.parseInt(o.number);
                if(thisNum == oNum) {
                    return Integer.compare(this.order, o.order);
                }
                return Integer.compare(thisNum, oNum);
            }
            return this.head.compareToIgnoreCase(o.head);
        }

        @Override
        public String toString() {
            return head+number+tail;
        }
    }
}