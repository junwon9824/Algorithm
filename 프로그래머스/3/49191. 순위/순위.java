class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] floyd = new int[n+1][n+1];
        
        // 초기화: 승패 정보 저장
        for (int [] v:results) {
            int A = v[0];
            int B = v[1];
            
            // A가 B를 이겼음
            floyd[A][B] = 1; 
            floyd[B][A] = -1; 
        }
        
        // 플로이드-워샬 알고리즘 적용
        for (int k = 1; k <= n; k++) {
            
            for (int i = 1; i <= n; i++) {
                
                for (int j = 1; j <= n; j++) {
                    
                    if (floyd[i][k] == 1 && floyd[k][j] == 1) {
                        floyd[i][j] = 1;
                        floyd[j][i] = -1;
                    }
                    
                    // if (floyd[i][k] == -1 && floyd[k][j] == -1) {
                    //     floyd[i][j] = -1;
                    //     floyd[j][i] = 1;
                    // }
                }
            }

        }
        
        // 각 선수에 대해 정확한 순위를 알 수 있는지 확인
        for (int i = 1; i <= n; i++) {
            
            int cnt = 0; 
            for (int j = 1; j <= n; j++) {
                if (floyd[i][j] != 0) cnt++;
            }
            if (cnt == n-1) answer++;
            
        }
        
        
        return answer;
    }
}
