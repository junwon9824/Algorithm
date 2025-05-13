import java.util.*;

class Solution {
    String [] str={"zero",
 "one",
 	"two",
 	"three",
 	"four",
 	"five",
 	"six",
 	"seven",
 	"eight",
 	"nine"
                   };
    
    
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0;i<10;i++){
            s=s.replaceAll(str[i] ,String.valueOf(i) ) ;
        }
        
        System.out.println("sss "+s);
        
        for(char ch : s.toCharArray() ){
            
            if('0'<=ch && '9'>=ch){
                answer*=10;
                
                 
                System.out.println(ch);
                answer+= Character.getNumericValue(ch);
                
            }
            
            
        }
        
        
        return answer;
    }
}