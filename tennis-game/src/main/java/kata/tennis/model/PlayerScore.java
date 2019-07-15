package kata.tennis.model;

public abstract class PlayerScore {

    private int score;

    public void clear() {
        setScore(0);
    }

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
