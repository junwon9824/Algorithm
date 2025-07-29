import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int max = -1;

        
        // 시작점 (i, j)
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                
                // 행의 공차 dr, 열의 공차 dc
                for(int dr = -N+1; dr < N; dr++) {
                    for(int dc = -M+1; dc < M; dc++) {

                        int r = i;
                        int c = j;
                        
                         if(dr==0&&dc==0) continue;
                        
                        StringBuilder sb = new StringBuilder();
                        
                        // 판 범위 안에 while, 1칸 이상만 탐색
                        while(0 <= r && r < N && 0 <= c && c < M) {
                            
                            // System.out.println("r c"+r+" "+c+" dr dc "+dr+" "+dc);
                            sb.append(board[r][c]);
                            int num = Integer.parseInt(sb.toString());
                            
                            // 완전 제곱수 판별
                            if(isPerfectSquare(num)) {
                                if(num > max) max = num;
                            }
                            
                            r += dr;
                            c += dc;
                            
                        }
                        
                    }
                }
                
                // dr, dc가 모두 0인 경우(자기 자신 한 칸)
                int num = board[i][j] - '0';
                
                if(isPerfectSquare(num)) {
                    if(num > max) max = num;
                }
                
            }
        }
        System.out.println(max);
    }

    // 완전 제곱수 판별 함수
    static boolean isPerfectSquare(int num){
        // if(num < 0) return false;
        int sqrt = (int)Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    
}
