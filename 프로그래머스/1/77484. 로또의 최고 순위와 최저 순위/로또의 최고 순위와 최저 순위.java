import java.util.*;

class Solution {

    int getrank(int size){
        
        if(size==6)return 1;
        else if(size==5)return 2;
        else if(size==4)return 3;
        else if(size==3)return 4;
        else if(size==2)return 5;
        else return 6;
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        // 0 개수 만큼 더하고 빼기 . 
        
        int sum=0;
        int min=0;
        int zero=0;
        int max=0;
        ArrayList<Integer> win_nums2=new ArrayList<>();
        
        for(int v:win_nums){
            win_nums2.add(v);    
        }
        
        
        for(int v:lottos){
            System.out.println( "v  "+v);
            
            if(win_nums2.contains(v))
                sum++;
            
            if(v==0)
                zero++;
        }
        
        min=sum;
        max=sum+zero;
        
        System.out.println(min+" max "+max+" sum "+sum);
        
        answer[0]=  getrank(max);
        answer[1]=  getrank(min);
        
        
        return answer;
    }
    
}