import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static    ArrayList<Integer> []list;
    static ArrayList<Integer> box;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 3
// 6 8 9
// 5
// 2 5 2 4 7
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]); 
        str = br.readLine().split(" "); 
        int [] crain=new int[N];
        
        for(int i=0;i<N;i++)
             crain[i] = Integer.parseInt(str[i] );
        
        str = br.readLine().split(" ");  //M
        M = Integer.parseInt(str[0]);  
        
        str = br.readLine().split(" "); 
        
        box =new ArrayList<>();
        
        for(int i=0;i<M;i++)
             box.add( Integer.parseInt(str[i]) );

        Collections.sort(box);
        Arrays.sort(crain);
        
        // 첫째 줄에 N이 주어진다. N은 50보다 작거나 같은 자연수이다. 둘째 줄에는 각 크레인의 무게 제한이 주어진다.
        //     이 값은 1,000,000보다 작거나 같다. 셋째 줄에는 박스의 수 M이 주어진다. M은 10,000보다 작거나 같은 자연수이다.
        //     넷째 줄에는 각 박스의 무게가 주어진다. 이 값도 1,000,000보다 작거나 같은 자연수이다.

        if(box.get(box.size()-1) > crain[crain.length-1]){
            System.out.println("-1");
            return;
        }

        long cnt=0;
        while ( true) {
                 // System.out.println(cnt + "round");

            if(box.size()==0)break;
           // System.out.println(box.size());
            int bsize=box.size();
            for(int i=0;i<N;i++){
                int v=crain[i];
                // v보다 작거나 같은것중 , 가장 큰 box 찾기.    
                
                int s=solve(v);
                // System.out.println(" v "+v+" s "+s + " val " + box.get(s)   ); 
                
                if(s==-1){ 
                    continue;
                }
                    
                box.remove(s);
                
            }
            
            int asize=box.size();
            // System.out.println(" bsize "+bsize+" asize "+asize);

            if(asize==bsize)
            {
                System.out.println("-1");
                return;
                
            }

            
            cnt++;
        }
        
        System.out.println(cnt  );
        
    }
    
        static int solve(int v ){
            int res=-1;
            int left=0;
            int right=box.size();

            while(left<right){
                
                int mid =(left+right)/2;
                // System.out.println("mid "+ mid  + " box.get(mid) "+box.get(mid)+" v "+v+" left  "+left+" right "+right);
                
                if(box.get(mid) <= v){
                    left=mid+1;
                    res=mid ;

                    if(box.get(mid)==v)break;
                }
                    
                else if(box.get(mid)>v){
                    right=mid;
                    
                }
                
            }

            // System.out.println("res "+res );
            return res;
            
        }
 

    
    
}