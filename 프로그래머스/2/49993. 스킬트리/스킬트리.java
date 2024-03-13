import java.util.*;

class Solution {
    
    static boolean check(String str,String skill){
        // System.out.println(str+skill);
        return skill.indexOf(str)==0?true:false;
        
    }
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String str:skill_trees) //
        {
            StringBuilder sb=new StringBuilder();
            
            for(char ch:str.toCharArray())
            {

                if(skill.contains(ch+"")){
                    sb.append(ch);
                }

            }

            if(check(sb.toString(),skill)){
                    answer++;
                }

        }
        
        return answer;
    }
}