package study.basic.exception;

public class StudentGrade {
    private String name;
    private int[] scores = new int[3];

    public StudentGrade(String name){
        this.name = name;
    }

    public void setScore(int index, int score) throws InvalidScoreException{
        if(index < 0 || index >= scores.length)
            throw new InvalidScoreException("과목 인덱스 오류: " + index);

        if(score < 0 || score > 100)
            throw new InvalidScoreException("점수는 0~100 사이어야 합니다: " + score);

        scores[index] = score;
    }

    public double getAverage() {
        int sum = 0;

        for(int score : scores)
            sum += score;

        return (double)sum/scores.length;
    }

    public void printReport() {
        System.out.println("학생: " + name);
        System.out.println("국어: " + scores[0] + ", 영어: " + scores[1] + ", 수학: " + scores[2]);
        System.out.printf("평균: %.1f\n", getAverage());
    }
}
