class Solution {
static String [] Friends;
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int hsize=friends.length;
        Friends=friends;
        
        int [][]give=new int[hsize][hsize];
        int [][]take=new int[hsize][hsize];
        int [] jisu =new int[hsize];
        
        //서로줫으면 더많이준사람이 받는다
        // 둘다 안줫으면 지수로 비교
        
        for(String str2: gifts)
        {
            String[]str=str2.split(" ");
            
            int from=number(str[0]);
            int to=number(str[1]);
            
            give[from][to]++;
            jisu[from]++;
            jisu[to]--;
            // take[to][from]=1;
        }
        
        int max=0;
        
        for(int i=0;i<hsize;i++){
            int tmp=0;
            //내가 더많이 준경우
            for(int j=0;j<hsize;j++){
                // System.out.println(Friends[i]+" "+tmp+" "+Friends[j]);
                
                if( give[i][j]> give[j][i] ){
                    tmp++;
                }
                else if( give[i][j]== give[j][i]  ){
                    if(jisu[i]>jisu[j])
                    {
                        tmp++;
                    }
                    
                }
                 
            }
            // System.out.println(i+" "+tmp);
            max=Math.max(max,tmp);
        }
        
        answer=max;
        return answer;
        
    }
    
    static int number(String str){
        
        for(int i=0;i<Friends.length;i++){
            if(str.equals(Friends[i]) )
            return i;
        }
            return 0;
        
    }
    
    
}