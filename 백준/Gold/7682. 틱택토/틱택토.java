 

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Main  {

// 만약 해당 값이
	static StringBuilder sb;
	static int res = Integer.MAX_VALUE;
	static char[][] ch;
	static int[] dr = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dc = { 0, 0, 1, -1, -1, 1, 1, -1 };

	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String str;
		// ch = new char[3][3];

		while (true) {
            
			int cnt = 0;
			str = br.readLine();
			if (str.equals("end")) {
				break;
			}

			ch = new char[3][3];
			int osize = 0, xsize = 0;

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					ch[i][j] = str.charAt(cnt++);
					if (ch[i][j] == 'O') {
						osize++;
					}
					if (ch[i][j] == 'X') {
						xsize++;
					}
				}
			}

            
			// System.out.println("osize xsize" + osize + " " + xsize);

            
    			if (play(osize, xsize)) {
                    // System.out.println(osize+" valid "+xsize);
                    
    				sb.append("valid").append('\n');
    			} 
                else
                {
                    // System.out.println(osize+" invalid "+xsize);
                    
    				sb.append("invalid").append('\n');
                }
		
        }
            

		System.out.println(sb.toString());
	}

	static boolean isfull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (ch[i][j] != 'X' && ch[i][j] != 'O') {
					return false;
				}
			}
		}
		return true;
	}

	static boolean play(int osize, int xsize) {
            // System.out.println(osize+" inplay "+xsize);
        
		if (((xsize - osize) == 1)) {
            
            if(isfull() ){
            // System.out.println(osize+" isfull "+xsize);
                
				if(isvalido()  ) 
                    return false;
                return true;
            }
            
			if (!isvalidx()) {
                // System.out.println("notx");
                
				return false;
			}
            
			if (isvalido()) {
                // System.out.println(" not o");
                
				return false;
			}

            
                // System.out.println(" trueee");
            
             return true;

		}
            
        else if(xsize==osize){
                // System.out.println(" same");

            if(isvalido() ){
                return true;
            }
    
            
            return false;
        }
        
        return false;
	}
 
	static 	boolean[][] visit = new boolean[3][3];
    
	static boolean isvalidx() {
		// System.out.println("inisv");
        int cnt=0;
        
		  // visit = new boolean[3][3];
        
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (bfs(i, j, ch[i][j]) == 3 && ch[i][j] == 'X' ) {
					cnt++;
				}
			}
		}
        
            // System.out.println("cnt"+cnt);

        if(cnt>=1){
            return true;
        }
        else
    		return false;
	}
    
	static boolean isvalido() {
		// System.out.println("inisv");
        int cnt=0;
        		  // visit = new boolean[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (bfs(i, j, ch[i][j]) == 3 && ch[i][j] == 'O' ) {
					cnt++;
				}
			}
		}

        if(cnt>=1){
            return true;
        }
            
        else
    		return false;
	}

	static int bfs(int r, int c, char tmp) {
        
		// System.out.println("in bfs");
        visit=new boolean [3][3];
        
		Queue<int[]> q = new LinkedList<>();
        
		for (int i = 0; i < 8; i++)
			q.add(new int[] { r, c, i, 1 });
        
		int cnt = 0;
		int res = Integer.MIN_VALUE;
		visit[r][c] = true;

		while (!q.isEmpty()) {
            
			int[] v = q.poll();
			int dir = v[2];
			int nr = v[0] + dr[dir];
			int nc = v[1] + dc[dir];
            
			// System.out.println("nr nc" + nr + " " + nc + "dir" + v[2]);

			if (valid(nr, nc) && !visit[nr][nc] && tmp == ch[nr][nc]) {
    			// System.out.println("ifffffffffff");
                
				q.add(new int[] { nr, nc, v[2], v[3] + 1 });
				visit[nr][nc] = true;
				res = Math.max(v[3] + 1, res);
                
				// System.out.println("in range res" + res);
                
			}

		}

		 // System.out.println("res" + res);
        
		return res;
        
	}

	static boolean valid(int r, int c) {
		return r >= 0 && r < 3 && c >= 0 && c < 3;
	}

}
