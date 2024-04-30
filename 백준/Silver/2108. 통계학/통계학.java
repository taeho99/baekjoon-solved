import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += arr[i] = sc.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        String avg = String.format("%.0f", sum / (double) n);
        System.out.println(avg.equals("-0") ? 0 : avg);
        Arrays.sort(arr);
        System.out.println(arr[n/2]);
        List<Integer> freq = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int value : map.values()) {
            max = Math.max(value, max);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max)
                freq.add(entry.getKey());
        }
        Collections.sort(freq);
        if(freq.size() == 1) {
            System.out.println(freq.get(0));
        } else {
            System.out.println(freq.get(1));
        }
        System.out.println(arr[n-1] - arr[0]);
    }
}
