import java.util.*;

class Solution {
    
    static boolean valid(int r,int c){
        return r>=0&&r<rsize&&c>=0&&c<csize;
    }
    
    static int rsize=0;
    static int csize=0;
    
    public int[] solution(String[] park, String[] routes) {
        rsize=park.length;
        csize=park[0].length();
        int[] answer = new int[2];
        
        String []dir={"N","S","W","E"};
          int []dr={-1,1,0,0};
          int []dc={0,0,-1,1};
        HashMap<String,Integer>map=new HashMap<>();
        
        for(int i=0;i<4;i++){
            map.put(dir[i],i);
        }
        
        int size=park.length;
        
        char [][] ch= new char[park.length][park[0].length()];
        
        
        int [] start=new int[2];
        
        for(int i=0;i<park.length;i++){
            ch[i]=park[i].toCharArray();
            
        }
        
        
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[0].length();j++){
            
                if(ch[i][j]=='S')
                {
                    start[0]= i;
                    start[1]= j;
                }
            
            }
        }
        
        
        for(String str:routes){
            // int direction= map.get(str.charAt(0));
            int direction= Integer.valueOf(map.get(String.valueOf(str.charAt(0))));
            int num= Integer.valueOf( String.valueOf(str.charAt(2)));
            boolean flag=false;
            
            int cr=start[0];
            int cc=start[1];
            for(int i=0;i<num;i++){
                
                int nr=start[0]+dr[direction];
                int nc=start[1]+dc[direction];
                
                if(valid(nr,nc)&&ch[nr][nc]!='X'){
                    start[0]=nr;
                    start[1]=nc;
                }
                else{
                    flag=true;
                }
                
            }
            if(flag){
                start[0]=cr;
                start[1]=cc;
            }
        }
        
        answer[0]=start[0];
        answer[1]=start[1];
        
        return answer;
    }
}