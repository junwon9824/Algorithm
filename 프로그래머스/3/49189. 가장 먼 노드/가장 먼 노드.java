import java.util.*;

class Solution {
    
    static int bfs(int n, List<List<Integer>> adjList) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        q.add(new int[] {1, 0}); // {노드, 거리}
        visit[1] = true;
        
        int max = 0;
        int maxCnt = 0;
        
        while (!q.isEmpty()) {
            int[] v = q.poll();
            int node = v[0];
            int dist = v[1];
            
            if (dist > max) {
                max = dist;
                maxCnt = 1;
            } else if (dist == max) {
                maxCnt++;
            }
            
            for (int neighbor : adjList.get(node)) {
                if (!visit[neighbor]) {
                    visit[neighbor] = true;
                    q.add(new int[] {neighbor, dist + 1});
                }
            }
        }
        
        return maxCnt;
    }
    
    public int solution(int n, int[][] edge) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            int s = e[0];
            int t = e[1];
            adjList.get(s).add(t);
            adjList.get(t).add(s);
        }
        
        return bfs(n, adjList);
    }
}
