
package strategy;

public class ExperienceStrategy implements ApplicationStrategy {

    private int minimumExperience;

    public ExperienceStrategy(int minimumExperience) {
        this.minimumExperience = minimumExperience;
    }

    @Override
    public boolean isEligible(int score, int yearsOfExperience) {
        return yearsOfExperience >= minimumExperience;
    }
}
