import java.io.*;
import java.util.*;

public class Main {
 
	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n,m,k,x,y;

        int [][]horse=new int[8][8];
        
        int [][]white=new int[8][8];

        
        for(int i=0;i<8;i++){
             String []str=br.readLine().split(" ");
            for(int j=0;j<8;j++){
                    if(str[0].charAt(j)=='F')//horse
                    {
                        horse[i][j]=1;
                        
                    }
            }
        }

        int su=1;

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                 white[i][j]=su;
                su=-su;
            }
                su=-su;
            
        }
        int res=0;


        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(white[i][j]==1&&horse[i][j]==1)
                    res++;
            }
                 
            
        }


        
      System.out.println ( res);
        
      

	}

}
