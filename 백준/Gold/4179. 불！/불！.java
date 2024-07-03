import java.io.*;
import java.util.*;

public class Main {
    static int []dr={1,-1,0,0};
    static int []dc={0,0,1,-1};
    static int R=0;
    static int C=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split(" ");
        R=Integer.parseInt(words[0]);
        C = Integer.parseInt(words[1]);
        char [][] ch=new char[R][C];
        int cnt=Integer.MAX_VALUE;
        
        int [] fire=new int[2];
        int [] jihoon=new int[2];
        Queue<int []> q=new LinkedList<>();
        
        for(int i=0;i<R;i++){
              String str = br.readLine();

            for(int j=0;j<C;j++){
                ch[i]=str.toCharArray();
                
                if(ch[i][j]=='J'){
                    jihoon[0]=i;
                    jihoon[1]=j;
                    // q.add(new int[]{i,j,0,0});
                }

                 if(ch[i][j]=='F'){
                    fire[0]=i;
                    fire[1]=j;
                    q.add(new int[]{i,j,1,0});
                }
                
            }
            
            
        }
        
        // q.add(new int[]{fire[0],fire[1],1,0});
        q.add(new int[]{jihoon[0],jihoon[1],0,0});

         // boolean flag=false;
        
        out:while(!q.isEmpty()){
            int []v=q.poll();
            // System.out.println("cur"+v[0]+" "+v[1]+" "+v[2] );
            
            if(v[2]==0 ) //jihoon
            {
                if(edge(v[0],v[1])){
                   System.out.println(1);
                    return;
                }
            }
            
            for(int i=0;i<4;i++){
                int nr=v[0]+dr[i];
                int nc=v[1]+dc[i];
                
                if(valid(nr,nc)&& ch[nr][nc]!='#' ){
                    if(v[2]==1&&ch[nr][nc] != 'F' ) //fire
                    {
                        // System.out.println("ffff"+nr+" "+nc+" "+v[3] );

                        q.add(new int[]{nr,nc,1,v[3]+1});    
                        ch[nr][nc]='F';

                    }
                    
                    if(v[2]==0 ) //jihoon
                    {
                        if(ch[nr][nc] == '.'){
                            // System.out.println("jihoon"+nr+" "+nc+" "+v[3]+1 );

                            q.add(new int[]{nr,nc,0,v[3]+1});
                            ch[nr][nc]='J';
                            if(edge(nr,nc)){
                                cnt=Math.min(cnt,v[3]+2);
                                // flag=true;
                                break out;
                            }
                        }
                        
                    }
                    
                }
            }
            
        }
        
                   System.out.println(cnt==Integer.MAX_VALUE?"IMPOSSIBLE":cnt );
}
      
    
    
    static boolean valid(int r,int c){
        return r>=0&&r<R&&c>=0&&c<C;
    }
    
     static boolean edge(int r,int c){
        return r==0||r==R-1||c==0||c==C-1;
    }
}
