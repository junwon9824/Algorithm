import java.io.*;
import java.util.*;

public class Main {
 
	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String []str=br.readLine().split(" ");

    int cnt=0;
        for(int i=0;i<str.length;i++){
            if(str[i]!="")
            {
                cnt++;
            }
        }
        
		// System.out.println(str[0]);
         
		// System.out.println(str[6]);

		System.out.println(cnt);

	}

}
