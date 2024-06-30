import java.io.*;
import java.util.*; 


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String exp = br.readLine();
        
        Stack<Character> st = new Stack<>();
        int expLen = exp.length();
        
        out: for (int i = 0; i < str.length(); i++) {
            
            st.add(str.charAt(i));
            
            if (st.size() >= expLen) {
                // System.out.println(st.size() + " "+expLen );
                
                for (int j = 0 ; j <expLen; j++) {
                    if ( st.get(st.size()-1-j) == exp.charAt(exp.length()-1-j ) ) {
                        
                    }
                    else{
                        continue out;
                    }
                    
                }
                
                for (int j = 0; j < expLen; j++) {
                    st.pop();
                }
                
            }
            
        }

        if (st.isEmpty()) {
            System.out.print("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char ch : st) {
                sb.append(ch);
            }
            System.out.print(sb.toString());
        }
        
    }
}
