import java.io.*;
import java.util.*;

public class Main {
     
          static  int [][]arr;
            static int [][]arr2;
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n,m;
    
            String[] str = br.readLine().split(" ");
            
            n= Integer.parseInt(str[0]);
            m= Integer.parseInt(str[1]);

            arr=new int[n][m];
            arr2=new int[n][m];

            
            for(int i=0;i<n;i++){
              str = br.readLine().split(" ");
                for(int j=0;j<m;j++){
                    arr[i][j]=(int)(str[0].charAt(j)-'0');
                }
                
            }

            for(int i=0;i<n;i++){
              str = br.readLine().split(" ");
                for(int j=0;j<m;j++){
                    arr2[i][j]=(int)(str[0].charAt(j)-'0');
                // System.out.println(  i+" "+j + " " +arr2[i][j]);
                    
                }
                
            }
        int cnt=0;
            
             for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){

                    if(i+2>=n|| j+2>=m)continue;
                // System.out.println(  i+" "+j );
                    
                    if(arr[i][j]==arr2[i][j]){
                        
                    }
                    else {
                        swap(i,j);
                        cnt++;
                    }
                        
                }
                
            }

            boolean flag=false;
            
             for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(arr[i][j]==arr2[i][j]){

                    }
                    else
                        flag=true;
                        
                }
                
            }
            
            System.out.println(flag==true?-1:  cnt );


            
        }
    
    static void swap(int k,int l){
        
        for(int i=k;i<k+3;i++){
            for(int j=l;j<l+3;j++){
                arr[i][j]=(arr[i][j]==1?0:1 );
            }
        }
        
    }


    
     
    }


