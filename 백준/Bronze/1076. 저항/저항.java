import java.io.*;
import java.util.*;

public class Main {
     
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String a,b,c;
    
            String[] str = br.readLine().split(" ");
            
            a= (str[0]);

             str = br.readLine().split(" ");
    
            b= (str[0]);

              str = br.readLine().split(" ");
    
           c= (str[0]);
            
            HashMap<String,String> map=new HashMap<>();
            
         map.put("black", "0");
        map.put("brown", "1");
        map.put("red",  "2");
        map.put("orange",  "3");
        map.put("yellow",  "4");
        map.put("green", "5");
        map.put("blue",  "6");
        map.put("violet", "7");  // 문자열로 변환
        map.put("grey", "8");    // 문자열로 변환
        map.put("white", "9");  // 문자열로 변환

            String res="";
        res+=map.get(a);
        res+=map.get(b);
            
        for(int i=0;i<Integer.parseInt(map.get(c)) ;i++)
            res+="0";
            
//             black	0	1
// brown	1	10
// red	2	100
// orange	3	1,000
// yellow	4	10,000
// green	5	100,000
// blue	6	1,000,000
// violet	7	10,000,000
// grey	8	100,000,000
// white	9	1,000,000,000
                

boolean flag=false;
            String res2="";
        for(int i=0;i< res.length() ;i++)
            {

                if(!flag && res.charAt(i)=='0'){
                    continue;
                }
                else{
                    flag=true;
                    res2+= res.charAt(i);
                }
                
            }

            if(res2.equals("")){
                res2="0";
            }

            
            System.out.println( res2 );


            
        }


    
     
    }


