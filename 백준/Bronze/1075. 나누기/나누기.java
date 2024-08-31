import java.io.*;

public class Main {
     
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
            String[] str = br.readLine().split(" ");
            
            int n,f;
    
            n=Integer.parseInt(str[0]);
            
             String[] str2 = br.readLine().split(" ");
            
    
            f=Integer.parseInt(str2[0]);

            String front="";
            
                
            for(int i=0;i<String.valueOf(n).length()-2;i++){
                front+=str[0].charAt(i);
                // System.out.println(i+" "+"ss"+front);
                
            }

                        // System.out.println(n+" "+"ff"+front);

            
          out:  for(int i=0;i<=9;i++){
                
                for(int j=0;j<=9;j++){
                      String temp=front;
                    temp+=i;
                    temp+=j;
                    
                    int v=Integer.parseInt(temp);
                    
                    if( v %f ==0 ){
                        String tmp="";
    
                        tmp+=i;
                        tmp+=j;
                        System.out.println(tmp);
                        break out;
                    }
                    
                }
                    
                
            }
                
            System.out.println(  );

        }


    
     
    }


