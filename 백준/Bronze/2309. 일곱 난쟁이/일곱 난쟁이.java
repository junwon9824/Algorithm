 
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] high = new int[9];
		int sum = 0;
		int pa = 0, pb = 0;

		for (int i = 0; i < high.length; i++) { 
			high[i] = sc.nextInt();
			sum += high[i]; // sum은 난쟁이 9명의 키의 합
		}
		
		Arrays.sort(high); // 키를 오름순서로 정렬

		for (int a = 0; a < high.length - 1; a++) {  
			for (int b = a + 1; b < high.length; b++) {
				if (sum - high[a] - high[b] == 100) {  
					pa = a;
					pb = b;
					break;
				}
			}
		}
		

		for (int j = 0; j < high.length; j++) { 
			
			if (j == pa || j == pb)  //7명 이기 때문에 두명제외
				continue;
			
			System.out.println(high[j]);
		}
		
		//sc.close();
	}
}