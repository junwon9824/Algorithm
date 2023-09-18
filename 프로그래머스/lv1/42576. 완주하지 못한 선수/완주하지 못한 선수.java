import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        
        String answer = ""; 
    	//hasp map 생성
        
        HashMap<String, Integer> map = new HashMap<>(); 
        
        for (String player : participant) 
       	
             map.put(player, map.getOrDefault(player, 0) + 1); //map 에 해당 플레이어 없으면 0을 초기화후  1 더한다.
        
        //Hash map에서 완주한 사람 빼기
        for (String player : completion)
             
             map.put(player, map.get(player) - 1); 
        
            for(String key : map.keySet()){
                if(map.get(key) != 0){// 완주하지 못한 사람 이 있으면 value 가  0보다  크다.
                answer = key;
                break;
                }
        
          }
        
        return answer; 
        
    }
}