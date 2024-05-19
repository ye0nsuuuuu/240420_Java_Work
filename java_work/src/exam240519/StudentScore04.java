package exam_240510;
public class StudentScore04 {
    private int[][] scores; //성적을 저장하는 2차원 배열

    // 생성자
    public StudentScore04(int[][] scores) {
        this.scores = scores;
    }

    // 총점 계산 메소드
    private int calculateTotal(int[] studentScores) {
        int total = 0;
        for (int score : studentScores) {
            total += score;//국 영 수 점수 합산
        }
        return total;
    }

    // 평균 계산 메소드
    private double calculateAverage(int[] studentScores) {
        return calculateTotal(studentScores) / (int) studentScores.length;
        // 총점을 과목 수로 나누어 평균 계산
    }
    }

    // 결과 출력 메소드
    public void printScores() {
        System.out.println("학생번호\t국어\t영어\t수학\t총점\t평균");
        System.out.println("=============================================");
        for (int i = 0; i < scores.length; i++) {
            int total = calculateTotal(scores[i]);
            double average = calculateAverage(scores[i]);
            System.out.printf("%d번 학생:\t%d\t%d\t%d\t%d\t%.1f\n", i + 1, scores[i][0], scores[i][1], scores[i][2], total, average);
        }
    }



    public static void main(String[] args) {
        int[][] scores = {
            {80, 60, 70}, 
            {90, 95, 80}, 
            {75, 80, 100}, 
            {80, 70, 95}, 
            {100, 65, 80}
        };
     // StudentScore04 객체 생성
        StudentScore04 studentScore = new StudentScore04(scores);
        studentScore.printScores();
    }
}
