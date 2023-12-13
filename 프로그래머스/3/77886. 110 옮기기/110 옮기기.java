import java.util.Stack;

 class Solution {
    public String[] solution(String[] s) {
        
        String[] answer = new String[s.length];
        StringBuilder sb;

        for(int i=0; i<s.length; i++) {
             // System.out.println("i"+i);
            
            String str = s[i];
            Stack<Character> stack = new Stack<>();
            int cnt = 0;
            
            for(int j=0; j<str.length(); j++) {
                
                char z = str.charAt(j);
                
                 // System.out.println("z"+z);
                
                if(stack.size()>=2) {
                    
                    char y = stack.pop();
                    char x = stack.pop();

                    if(x=='1' && y=='1' && z=='0') {
                        cnt++;
                    } 
                    
                    else {
                        stack.push(x);
                        stack.push(y);
                        stack.push(z);
                    }
                    
                }
                
                else {
                    stack.push(z);
                }
                
            }

            int idx = stack.size();
            boolean flag = false;
            sb = new StringBuilder();
            
            while(!stack.isEmpty()) {
                
                if(!flag && stack.peek()=='1') {
                    idx--;
                    // System.out.println("chPEEK1");
                }
//10110  
                if(!flag && stack.peek()=='0') {
                    flag = true;
                    // System.out.println("chPEEK0");
                }
                
                char ch=stack.pop();
                // System.out.println("ch"+ch);
                sb.insert(0, ch);
                
            }

            if(cnt>0) {
                
                while(cnt>0) {
                    sb.insert(idx, "110");
                    idx += 3;
                    cnt--;
                }
                
                answer[i] = sb.toString();
                
            }
            
            else {
                answer[i] = s[i];
            }
            
        }
        
        return answer;
    }
}