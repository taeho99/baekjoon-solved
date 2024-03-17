import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            List<String> result = new ArrayList<>();
            for (int i : course) {
                combine(arr, 0, i, new StringBuilder(), result);
            }
            for (String r : result) {
                map.put(r, map.getOrDefault(r, 0) + 1);
            }
        }

        List<String> answer = new ArrayList<>();
        for (int i : course) {
            HashMap<Integer, List<String>> result = new HashMap<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if(entry.getKey().length() == i) {
                    if(!result.containsKey(entry.getValue())) {
                        result.put(entry.getValue(), new ArrayList<>());
                    }
                    result.get(entry.getValue()).add(entry.getKey());
                }
            }
            System.out.println(result);
            int max = 0;
            for (int integer : result.keySet()) {
                if(integer > max) {
                    max = integer;
                }
            }
            if(max == 0 || max == 1) continue;
            answer.addAll(result.get(max));
        }
        return answer.stream().sorted().toArray(String[]::new);
    }

    private static void combine(char[] arr, int start, int k, StringBuilder path, List<String> result) {
        if(k==0) {
            result.add(path.toString());
            return;
        }

        for(int i=start; i<=arr.length - k; i++) {
            path.append(arr[i]);
            combine(arr, i+1, k-1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}