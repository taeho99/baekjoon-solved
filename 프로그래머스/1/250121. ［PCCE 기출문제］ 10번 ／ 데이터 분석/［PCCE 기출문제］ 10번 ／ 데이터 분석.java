import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        HashMap<String, Integer> option = new HashMap<>();
        option.put("code", 0);
        option.put("date", 1);
        option.put("maximum", 2);
        option.put("remain", 3);

        List<Data> answer = new ArrayList<>();
        for (int[] d : data) {
            if(d[option.get(ext)] < val_ext) {
                answer.add(new Data(new int[] {d[0], d[1], d[2], d[3]}));
            }
        }

        answer.sort(Comparator.comparingInt(o -> o.arr[option.get(sort_by)]));

        int[][] result = new int[answer.size()][4];
        for(int i=0; i<result.length; i++) {
            result[i] = answer.get(i).arr;
        }
        return result;
    }

    class Data {
        int[] arr;

        public Data(int[] arr) {
            this.arr = arr;
        }
    }
}