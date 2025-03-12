import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        
        for (long i = 0; i < n; i++) {
            long s = Long.parseLong(br.readLine());
            solve(s);
        }
        
    }

    static boolean sosu(long n) {
        if (n < 2) return false; // 0 and 1 are not prime numbers
        if (n == 2) return true; //  
        if (n % 2==0) return false; //  
            
        for (long i = 3; i <= Math.sqrt(n); i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void solve(long start) {
        long left = start ; // Start searching for the next prime after 'start'
        long right =  4000000000L;  
        long res = -1; // Initialize to -1 to indicate no prime found
        
        // System.out.println(left+ " "+right);
        
        while (true) {
             if (sosu(left)) {
                break;
            } 
            left++;
            
            // long mid = (left + right) / 2;
            // System.out.println(left+ " "+right+" "+mid);

            // if (sosu(mid)) {
                
            //     res = mid; // Found a prime
            //       right = mid; // Look for a smaller prime
            // } 
            
            // else {
            //     left = mid + 1; // Look for a larger prime
            // }
        }

        System.out.println(left);
    }
}
