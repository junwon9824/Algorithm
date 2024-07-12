import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        // sc.close();

        System.out.println(countOnes(b) - countOnes(a - 1));
    }

    public static long countOnes(long x) {
        if (x < 0) return 0;

        long count = 0;
        for (long i = 0; (1L << i) <= x; i++) {
            long blockSize = 1L << (i + 1);
            long fullBlocks = (x + 1) / blockSize;
            long remainder = (x + 1) % blockSize;
            
            
            count += fullBlocks * (blockSize / 2) + Math.max(0, remainder - (blockSize / 2));
            // System.out.println("i x b f r c"+i+" "+x+" "+blockSize+" "+fullBlocks+" "+remainder+" "+count);
            
        }
        
        return count;
    }
    
}
