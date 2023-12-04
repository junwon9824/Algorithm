// import java.util.*;

class Solution {
    public int R, C;
    
    public int[][] B, T, tmp;

    public void flipCol(int c) {
        for (int i = 0; i < R; i++)
            tmp[i][c] = tmp[i][c] == 0 ? 1 : 0;
    }

    public void copyArr() {
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                tmp[i][j] = B[i][j];
    }

 public void flipRow(int r) {
        for (int j = 0; j < C; j++) {
            tmp[r][j] = tmp[r][j] == 0 ? 1 : 0;
        }
    }

    public int solution(int[][] beginning, int[][] target) {
        R = beginning.length;
        C = beginning[0].length;
        B = beginning;
         
        tmp = new int[R][C];
        int result = Integer.MAX_VALUE;
        //모든 열에 대해서 반복
        
        for (int mask = 0; mask < 1 << C; mask++) {
            
            int tmpResult = 0;
            copyArr();
            
            //1. 칼럼 뒤집기
            for (int col = 0; col < C; col++) {
                //뒤집지 않는 열의 경우 냅둠
                if ((mask & 1 << col) == 0) continue;
                
                tmpResult++;
                flipCol(col);
            }
             
            
         for (int row = 0; row < R; row++) {
             
            int rowDiff = 0;
            for (int col = 0; col < C; col++) {
                if (tmp[row][col] != target[row][col]) {
                    rowDiff = 1;
                    break;
                }
            }
            if (rowDiff == 1) {
                flipRow(row);
                tmpResult++;
            }
        }
            
        // 일치 여부 확인
        boolean isEqual = true;
            
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (tmp[row][col] != target[row][col]) {
                    isEqual = false;
                    break;
                }
            }
            if (!isEqual) break;
        }

        if (isEqual) {
            result = Math.min(result, tmpResult);
        }
            
        }
        
        if (result == Integer.MAX_VALUE) return -1;
        else return result;
    }
    
}