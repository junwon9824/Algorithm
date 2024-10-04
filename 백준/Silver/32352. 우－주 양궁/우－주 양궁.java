import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 화살의 직육면체 정의
        long Xlo = scanner.nextLong();
        long Xhi = scanner.nextLong();
        long Ylo = scanner.nextLong();
        long Yhi = scanner.nextLong();
        long Zlo = scanner.nextLong();
        long Zhi = scanner.nextLong();
        
        // 과녁의 직육면체 정의
        long xlo = scanner.nextLong();
        long xhi = scanner.nextLong();
        long ylo = scanner.nextLong();
        long yhi = scanner.nextLong();
        long zlo = scanner.nextLong();
        long zhi = scanner.nextLong();
        
        // 충돌 여부 확인
        long frame = -1;

        // x축 충돌 체크
        boolean xCollision = Math.max(Xlo, xlo) < Math.min(Xhi, xhi);
        // y축 충돌 체크
        boolean yCollision = Math.max(Ylo, ylo) < Math.min(Yhi, yhi);
        
        // x축과 y축에서 충돌이 발생할 경우
        if (xCollision && yCollision) {
            // z축 충돌 체크
            long t = 0;
            while (true) {
                
                long currentZlo = Zlo - t;
                long currentZhi = Zhi - t;
                boolean Collision = Math.max(currentZlo, zlo) < Math.min(currentZhi, zhi);

                // z축에서 충돌 여부
                if (Collision) {
                    frame = t;
                    break;
                }

                // zUpper가 zlo보다 작아지면 더 이상 체크할 필요 없음
                if (currentZhi < zlo) {
                    break;
                }

                t++;
            }
        }

        // 결과 출력
        System.out.println(frame);
        scanner.close();
    }
}
