import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫째 줄에서 N, M, K, X 읽기
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        int X = scanner.nextInt();

        // 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 도로 정보 읽기
        for (int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            graph.get(A).add(B);
            // graph.get(B).add(A);
        }

        // BFS를 위한 거리 배열과 큐 초기화
        int[] distances = new int[N + 1];
        Arrays.fill(distances, -1); // -1로 초기화
        distances[X] = 0; // 시작 도시의 거리는 0

        
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{X,0});

        ArrayList<Integer> res=new ArrayList<>();
        
        // BFS 수행
        while (!queue.isEmpty()) {
            int []v = queue.poll();

            for (int neighbor : graph.get(v[0])) {
                
                if (distances[neighbor] == -1) { // 방문하지 않았다면
                    distances[neighbor] = v[1]+1;
                    
                    if(distances[neighbor]==K){
                        res.add(neighbor);
                    }
                    queue.add(new int[]{neighbor,v[1]+1});
                }
                
            }
            
        } 

        res.sort((a,b)->{
           return a-b; 
        });
        
        for(int v:res)
            System.out.println(v);

        if(res.size()==0)
            System.out.println(-1);
        
        scanner.close();
        
    }
}
