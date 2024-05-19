package exam_240510;
import java.util.Scanner;
import java.util.Random;

public class NumberGame01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//스캐너 입력도구  A a = new A
        Random random = new Random();//랜덤 객체 생성
        
        System.out.println("=== 숫자맞추기 게임을 시작합니다. ===");
        
       
        int secretNumber = random.nextInt(100) + 1;//1부터 100까지의 랜덤한 수 생성해서 secretNumber 에 담기
        
        System.out.println("컴퓨터가 숫자를 생각했습니다");
        
        
        String hint = (secretNumber % 2 == 0) ? "짝수" : "홀수";//secretNumber를 2로 나누어 0으로 떨어지는지 
        System.out.println("힌트는 " + hint + "입니다.");
        
        
        int trynumber = 0; 
        //사용자가 정답을 맞출때까지 반복
        while (true) {
            System.out.print("1~100 사이의 값을 입력 >>");
            try {
                int userGuess = scanner.nextInt();//입력 받기
                trynumber++;//시도횟수+
                
                if (userGuess > secretNumber) {
                    System.out.println("더 작은 수입니다.");
                } else if (userGuess < secretNumber) {
                    System.out.println("더 큰 수입니다.");
                } else {
                    System.out.println(trynumber + "회만에 맞췄습니다.");
                    System.o0ut.println("=== 게임을 종료합니다. ===");
                    break;
                }
            } catch (Exception e) {
                System.out.println("올바른 숫자를 입력하세요.");
                scanner.next(); 
            }
        }
        
        scanner.close();//스캐너 반납
    }
}

