package kata.tennis.model;

public class PlayerGameScore extends PlayerScore {

    private boolean deuce;
    
    

    @Override
    public void clear() {
        super.clear();
        setDeuce(false);
    }

	public boolean isDeuce() {
		return deuce;
	}

	public void setDeuce(boolean deuce) {
		this.deuce = deuce;
	}
}
