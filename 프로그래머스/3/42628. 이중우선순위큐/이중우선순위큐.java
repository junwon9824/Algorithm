import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        // operations=new String[]{"I 16", "D -1","I 10","D -1","I 10"}; 
        // operations=new String[]{"I 0","I -1","D 1"  }; 

        PriorityQueue<Integer> min=new PriorityQueue<>();
        PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
        
        int size=0;
        
        for(String str:operations )
        {
            String []tmp=str.split(" ");
            
            if(tmp[0].charAt(0)=='I' )
            {
                min.add(Integer.valueOf(tmp[1]));
                max.add(Integer.valueOf(tmp[1]));
                size++;
            }
            
            else{ //delete
                
                if(size==0)
                {
                    
                    continue;
                }
                
                if(size==1){
                    
        min=new PriorityQueue<>();
        max=new PriorityQueue<>(Collections.reverseOrder());
                    size--;
                    continue;
                }
                
                if(tmp[1].charAt(0)=='1'&&!max.isEmpty()){
                    int v=max.poll();
                    min.remove(min.size()-1);
                    
                    size--;
                }
                
                else if(!min.isEmpty()){
                    min.poll();
                    max.remove(max.size()-1);
                    
                    size--;
                }
                
            }
        
        }
        
        if(size==0)
        {
            
        }
         
        
        else{
            // System.out.println(size);
            answer[0]=max.peek();
            answer[1]=min.peek();

        }
        return answer;
    }
}