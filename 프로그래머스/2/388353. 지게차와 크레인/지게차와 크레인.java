import java.util.*;

class Solution {
     int n, m;
     char[][] grid;
     boolean[][] visited;
     int[] dx = {-1, 1, 0, 0}; // 상하좌우
     int[] dy = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        
        n = storage.length;
        m = storage[0].length();
        grid = new char[n][m];

        // 2D char 배열로 변환
        for (int i = 0; i < n; i++) {
            grid[i] =storage[i].toCharArray();
        }

        for (String req : requests) {
            
            char target = req.charAt(0);
                System.out.println(req);
            
            if (req.length() == 1) {
                // 지게차 요청
                visited = new boolean[n][m];
                // 가장자리에서 BFS 시작
                for (int i = 0; i < n; i++) {
                    if (!visited[i][0]) bfs(i, 0, target);
                    if (!visited[i][m - 1]) bfs(i, m - 1, target);
                     // bfs(i, 0, target);
                     // bfs(i, m - 1, target);
                }
                
                for (int j = 0; j < m; j++) {
                    if (!visited[0][j]) bfs(0, j, target);
                    if (!visited[n - 1][j]) bfs(n - 1, j, target);
                    // bfs(0, j, target);
                    // bfs(n - 1, j, target);
                }
                
            }
            
            else {
                // 크레인 요청
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (grid[i][j] == target) {
                            grid[i][j] = '.'; // 제거
                            System.out.println(i+" "+j);
                        }
                    }
                }
            }
            
        }

        // 남은 컨테이너 세기
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print( grid[i][j]+" ");
                
                if (grid[i][j] != '.') count++;
            }
            System.out.println();
        }

        return count;
    }

      void bfs(int x, int y, char target) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        // visited = new boolean[n][m];
          
        // visited[x][y] = true;

        while (!queue.isEmpty()) {
            
            int[] cur = queue.poll();
            
            int cx = cur[0];
            int cy = cur[1];
            // System.out.println(cx+" cxcy "+cy+" "+target+" "+grid[cx][cy]);
            
            // if(visited[cx][cy])continue;
            
            if (grid[cx][cy] == target) {
                visited[cx][cy]=true;
                grid[cx][cy] = '.'; // 꺼냄
                // if(cx==2)
                
                // System.out.println(cx+" cccccccccccccc "+cy);
                continue;
            }
            else if (grid[cx][cy] == '.') {
                
            }
            else{
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if (valid(nx,ny)){
                    if(visited[nx][ny])continue;
                    
                    visited[nx][ny] = true;
                    if (grid[nx][ny] == '.') {
                        // System.out.println(nx+" nn "+ny);
                        
                        queue.add(new int[]{nx, ny});
                    } 
                    if (grid[nx][ny] == target) {
                        grid[nx][ny] = '.'; // 
                        // if(nx==2)
                        // System.out.println(nx+" ddddddddddddddddd "+ny);
                        
                    }
                    
                }
                    
            }
        }
    }
    
    boolean valid(int nx, int ny){
             return nx >= 0 && nx < n && ny >= 0&&  ny < m   ;
    }
    
    
}
