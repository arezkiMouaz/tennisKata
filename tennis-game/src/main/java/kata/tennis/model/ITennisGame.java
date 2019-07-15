package kata.tennis.model;

public interface ITennisGame {
	
	
	
	void winPoint(String name);
	
    void winTheGame(String name);

    void winTheSet(String name);

    void winTheMatch(String name);

    

    void resetGameScores();

    void resetSetScores();

    String getPlayerName(String name);

    int getPlayerGameScore(String name);

    int getPlayerSetScore(String name);

    boolean isPlayerDeuce(String name);

    void setPlayerDeuce(Player player, boolean deuce);

    void setPlayerGameScore(Player player, int score);

    void setPlayerSetScore(Player player, int score);

    Player getGameWinner();

    Player getSetWinner();



 

    void clearPlayers();

    int getPlayerTieBreakScore(String name);

    void setPlayerTieBreakScore(String name, int score);
}
