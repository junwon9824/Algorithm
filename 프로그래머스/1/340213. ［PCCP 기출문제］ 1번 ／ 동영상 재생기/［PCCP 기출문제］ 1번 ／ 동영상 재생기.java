class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int cpos=convert(pos);
        int ostart= convert( op_start);
        int oend= convert( op_end);
        int size= convert( video_len);
        
         if( ostart<=cpos&&cpos<=oend ){
            cpos=oend;
             
         }
        
        for(String str: commands){
                
            if(str.equals("prev")){
                if(cpos>10){
                    cpos-=10;
                }
                else
                    cpos=0;
            }
            
           else if(str.equals("next")){
               if(cpos+10>size)
               {
                   cpos=size;
               }
               else
                    cpos+=10;
                
                
            }
            
         if( ostart<=cpos&&cpos<=oend ){
            cpos=oend;
             
         }
            
        }
        
        int m=0;
        int s=0;
        
        m=cpos/60;
        s=cpos%60;
        
        if(m<10)
        answer+="0"+m;
        else
        answer+=m;
            
        
        answer+=":";
          if(s<10)
        answer+="0"+s;
        else
        answer+=s;
        
        return answer;
    }
    
    static int convert(String str ){
        
        String []tmp= str.split(":");
        
        int m=Integer.parseInt(tmp[0]);
        int s=Integer.parseInt(tmp[1]);
            
            
        return m*60+s;
        
    }
    
}