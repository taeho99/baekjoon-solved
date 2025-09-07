import java.util.*;
class Solution {
    HashMap<String, ArrayList<String>> graph = new HashMap<>();
    List<String> answer = new ArrayList<>();
    int totalTickets;
    public String[] solution(String[][] tickets) {
        totalTickets = tickets.length;
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        for(String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];
            
            if(!graph.containsKey(start)) {
                graph.put(start, new ArrayList<>());
            }
            
            graph.get(start).add(end);
        }
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs("ICN", path);
        
        return answer.toArray(new String[0]);
    }
    
    boolean dfs(String current, List<String> path) {
        if(path.size() == totalTickets + 1) {
            answer.addAll(path);
            return true;
        }
        
        if(!graph.containsKey(current)) return false;
        
        for(int idx=0; idx<graph.get(current).size(); idx++) {
            String next = graph.get(current).get(idx);
            graph.get(current).remove(idx);
            path.add(next);
            if(dfs(next, path)) return true;
            path.remove(path.size() - 1);
            graph.get(current).add(idx, next);
        }
        return false;
    }
}