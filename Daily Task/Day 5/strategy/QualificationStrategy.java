
package strategy;

public class QualificationStrategy implements ApplicationStrategy {

    private int minimumScore;

    public QualificationStrategy(int minimumScore) {
        this.minimumScore = minimumScore;
    }

    @Override
    public boolean isEligible(int score, int yearsOfExperience) {
        return score >= minimumScore;
    }
}
