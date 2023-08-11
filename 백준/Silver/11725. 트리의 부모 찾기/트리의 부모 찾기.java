

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	static int[] arr;
	static int[] sum;
	static String str = "";
	static ArrayList<Integer>[] list ;

	
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		 list = new ArrayList[n+1];
		
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());

			list[a].add(b);
			list[b].add(a);

		}

		parent = new int[n + 1];

		dfs( n,1,0);
		
		for(int i=2;i<=n;i++)
			System.out.println(parent[i]);
		
		
		long end = System.currentTimeMillis();

	}

	public static void dfs(int n,int cur,int par)
	{
		parent[cur]= par;
		
		for(int i:list[cur] )
		{
			if(i!=par)
			{
				dfs( n,i,cur);
			}
				
		}
		
	}
	
	
}
