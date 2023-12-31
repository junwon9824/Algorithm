 
import java.io.*;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main  {
	static int arr[];
	static int[] parent;
    //union find 이용 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i; //우선 각자를 부모로 설정 
		}

		int cnt = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
 			if (!union(u, v)) { //일단 union 한다. 만약 부모가 같은 경우는 아무것도 하지않고 false return.
				cnt++; //union 이 false 인 경우 사이클이 발생하기 때문에 끊어야 한다. 끊는과정
                //도 포함해서 작업해야 하기때문에 1증가
			}
		}

		HashSet<Integer> hs = new HashSet<>(); //중복 제거위해 hashset 사용.
		for (int i = 1; i <= n; i++) {
			hs.add(find(i)); //부모의 총 개수를 구한다.
		}
		cnt += hs.size() - 1; // n개의 덩어리 를 연결하는 작업은  1을 빼야 하므로 (2개의 덩어리 연결하려면 
        // 1개의 선이 필요)
		System.out.println(cnt);

	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[a] = b;
			return true;
		}
		//System.out.println("ab "+a+" "+b);
		return false;
	}

	static int find(int a) {
		if (a == parent[a])
			return a;
		else {
			return   (parent[a] = find(parent[a])); 

		}
	}

}