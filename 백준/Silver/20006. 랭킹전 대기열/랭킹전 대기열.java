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

	static class point   {
		int level;
		String id;

		public point(int level, String id) {
			this.level = level;
			this.id = id;
		}
 

	}
    
    @SuppressWarnings("unchecked")

	public static void main(String args[]) throws Exception {

		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bReader.readLine());

		int p = Integer.parseInt(stringTokenizer.nextToken());
		int m = Integer.parseInt(stringTokenizer.nextToken());

		ArrayList<point> dq = new ArrayList<>();
		ArrayList<point> [] room = new ArrayList [ p ];

        for(int i=0;i<p;i++){
            room[i]=new ArrayList<>();
        }
        
		Stack<point> stack = new Stack();

		for (int i = 0; i < p; i++) {
			StringTokenizer st= new StringTokenizer(bReader.readLine());
			int l = Integer.parseInt(st.nextToken());
			String n = st.nextToken();
            
			dq.add(new point(l, n));
		}
        
        boolean visit[]=new boolean[p];
            int roomidx=0;
        
        
        for (int j = 0; j < p; j++) {

            if(visit[j])continue;

            visit[j]=true;
            int origin=dq.get(j).level ;
            room[roomidx].add(new point(origin,dq.get(j).id));
            
            for (int i = j+1; i < p; i++) {
                point p2= dq.get(i);
                
                if(room[roomidx].size()>=m){
                    break;
                }
                
                if(visit[i])continue;
                
                if(Math.abs(p2.level-origin)<=10 )
                {
                    room[roomidx].add(new point(p2.level,p2.id));
                    visit[i]=true;
                
                }
                
    		}
                    roomidx++;
            

	}


		for (int i = 0; i < roomidx; i++) {
            room[i].sort(  Comparator.comparing(a->a.id));
            
            if(room[i].size() ==m ){
                System.out.println("Started!");
                for(point p2:room[i] ){
                    System.out.println(p2.level+" "+p2.id);
                    
                }
            }
            else{
                System.out.println("Waiting!");
                  for(point p2:room[i] ){
                    System.out.println(p2.level+" "+p2.id);
                      
                        
                    }
                
            }
            
		}
//  

}
}