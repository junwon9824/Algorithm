 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n, h, w, m;
	static int ans;
    static int[] arr = new int[21];
    
 static void back(int k, int j){ //j 신분상승
        int tmp=arr[j];
        //원래 j 앞부터 k 까지 뒤로 한칸씩
         for(int i=j-1;i>=k ;i--)
         {
           arr[i+1]=arr[i];
         }
         arr[k]=tmp;
            
        }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = 0;
			
			for (int j = 0; j < 21; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 1; j < arr.length; j++) {
                int idx=0;
                //띄엄띄엄 큰 사람이 배치된경우
                
				for (int k = 1; k < j; k++) {

					if (arr[j] < arr[k])
                    {
                        idx=k;
                        cnt+=j-k+1-1;
//System.out.println("tc"+arr[0]+" "+j+" ssss "+cnt);


                        back(k,j);
                        break;
                    }
				}

			}
			
			System.out.print(arr[0]+" ");
			System.out.println(cnt);

		}
       

	}

}
