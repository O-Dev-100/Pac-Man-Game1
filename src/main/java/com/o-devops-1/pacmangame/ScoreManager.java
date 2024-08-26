public class ScoreManager {
    private int score;

    public ScoreManager() {
        score = 0;
    }

    public void incrementScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    public void resetScore() {
        score = 0;
    }}
