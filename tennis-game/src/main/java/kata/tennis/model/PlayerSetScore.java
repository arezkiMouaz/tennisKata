package kata.tennis.model;

public class PlayerSetScore extends PlayerScore {
   
    private int tieBreak;

	public int getTieBreak() {
		return tieBreak;
	}

	public void setTieBreak(int tieBreak) {
		this.tieBreak = tieBreak;
	}
}