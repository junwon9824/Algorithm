class Solution {
    static int []dr={1,0,0,-1};
    static int []dc={0,1,-1,0};
    static int rsize=0;
    static int csize=0;
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        rsize=board.length;    
        csize=board[0].length;    
        
        for(int i=0;i<4;i++){
            int nr=h+dr[i];
            int nc=w+dc[i];
            
            if(isvalid(nr,nc)&& board[nr][nc].equals(board[h][w]) ){
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean isvalid(int r,int c){
        return r>=0&&r<rsize&&c>=0&&c<csize;
    }
    
}