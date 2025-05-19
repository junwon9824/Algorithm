import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            graph[b].add(a); // b를 해킹하면 a도 해킹 가능
            
        }

        int[] count = new int[n + 1];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            
            count[i] = bfs(i);
            max = Math.max(max, count[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (count[i] == max) sb.append(i).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    static int bfs(int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int cnt = 1; // 자신도 포함

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    cnt++;
                    queue.add(next);
                }
            }
        }
        return cnt;
    }
}
