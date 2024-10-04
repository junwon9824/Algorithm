import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 화살의 직육면체 정의
        int Xlo = scanner.nextInt();
        int Xhi = scanner.nextInt();
        int Ylo = scanner.nextInt();
        int Yhi = scanner.nextInt();
        int Zlo = scanner.nextInt();
        int Zhi = scanner.nextInt();
        
        // 과녁의 직육면체 정의
        int xlo = scanner.nextInt();
        int xhi = scanner.nextInt();
        int ylo = scanner.nextInt();
        int yhi = scanner.nextInt();
        int zlo = scanner.nextInt();
        int zhi = scanner.nextInt();
        
        // 충돌 여부 확인
        int frame = -1;

        // x축 충돌 체크
        boolean xCollision = Math.max(Xlo, xlo) < Math.min(Xhi, xhi);
        // y축 충돌 체크
        boolean yCollision = Math.max(Ylo, ylo) < Math.min(Yhi, yhi);
        
        // x축과 y축에서 충돌이 발생할 경우
        if (xCollision && yCollision) {
            // z축 충돌 체크
            int t = 0;
            while (true) {
                
                int currentZlo = Zlo - t;
                int currentZhi = Zhi - t;
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
