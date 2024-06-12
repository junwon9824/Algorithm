import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
        HashMap<String,Integer> map=new HashMap<>();
        // genres=new String[]{ };
        // plays=new int[]{ };
        HashMap<String,ArrayList<int[]> > list=new HashMap<>();
        
        int idx=0;
        
        for(String str:genres){
            
            if(!list.containsKey(str))
            {
                list.put(str, new ArrayList<>() );
            }
            list.get(str).add( new int[]{idx, plays[idx]} );
            
            int size= map.getOrDefault(str,0)+plays[idx++];
            map.put(str, size);
        }
        
        ArrayList<String> genreorder =new ArrayList<>(map.keySet());
        
        genreorder.sort((a,b)-> map.get(b)-map.get(a) ) ;
        
        int size=0;
        
        for(String str:genreorder){
            
            ArrayList<int[]> samegenreorder =new ArrayList<>(list.get(str) );
            System.out.println(samegenreorder);
            
            size+=Math.min(2,samegenreorder.size()) ;

        }
        
        int[] answer = new int[ size];
        
        idx=0;
        
        for(String str:genreorder){
            ArrayList<int[]> samegenreorder =new ArrayList<>(list.get(str) );
            samegenreorder.sort((a,b)->b[1]-a[1] );
            
            for(int i=0;i<Math.min(2,samegenreorder.size());i++)
            answer[idx++]=samegenreorder.get(i)[0];
            
        }
        
        return answer;
    }
    
}
