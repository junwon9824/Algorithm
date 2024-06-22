import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String,Integer> map=new HashMap<>();
        
        for( int i=0;i<name.length;i++ ){
            map.put(name[i],yearning[i] );
            
        }
        
        int idx=0;
        for( String []strs: photo ){
            int tmp=0;
            
            for( String str: strs){
                
                if(map.containsKey(str) ){
                    tmp+= map.get(str);
                }
                
            }
           answer[idx++]= tmp;
            
        }
        
        
        return answer;
        
        
    }
}