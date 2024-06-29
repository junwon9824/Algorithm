 

import java.io.*;
import java.util.*;

public class Main  {

    static int n;
    
	public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        String  str=br.readLine();
          n=Integer.parseInt(str  ); 
        
        int []arr=new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        HashSet<Integer> hs=new HashSet<>();
        
        String []str2=br.readLine().split(" ");
       // System.out.println("str2"+str2.length);
        
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(str2[i]); 
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        Arrays.sort(arr);
        int cnt=0;
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sum=arr[i]+arr[j];

                if(!map.containsKey(sum))continue;
                
                if( arr[i]==0&& arr[j]==0){
                   if( map.get(sum)>2){
                       cnt+=map.get(sum);
                        map.put(sum,0);
                   }
                }
                    
                else if( arr[i]==0 || arr[j]==0){
                   if( map.get(sum)>1){
                        cnt+=map.get(sum);
                        map.put(sum,0);
                       // hs.add(sum);
                   }
                    else
                    continue;
                }
                    
                
                else if( map.get(sum)==1){
                    // cnt++;
                       hs.add(sum);
                    
                }
                  else if( map.get(sum)>1){
                    cnt+= map.get(sum);
                      map.put(sum,0);
                       // hs.add(sum);
                }
                
                // System.out.println(cnt+" sum "+sum+" i "+arr[i]+" j "+arr[j]);
            
            }
        }

        cnt+=hs.size();
        
        System.out.println(cnt);
        
	}
 
     

}
