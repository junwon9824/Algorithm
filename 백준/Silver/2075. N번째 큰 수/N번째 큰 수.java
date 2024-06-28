import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.*;

class Main {
	static String str;
	static int size;
	static int len = 0;
	static int min = Integer.MAX_VALUE;
 
    
    // @SuppressWarnings("unchecked")

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer stringTokenizer = new StringTokenizer(bReader.readLine());

        int N=Integer.parseInt(br.readLine());
        ArrayList<Integer> list=new ArrayList<>();
        

        for(int i=0;i<N;i++){
            String []str=br.readLine().split(" ");
            for(int j=0;j<N;j++){
                int tmp=Integer.parseInt(str[j]);
                
                list.add(tmp);
            }
            
        }
        list.sort((a,b)->  b-a);
        System.out.println(list.get(N-1));
 
//  

    }
    
}