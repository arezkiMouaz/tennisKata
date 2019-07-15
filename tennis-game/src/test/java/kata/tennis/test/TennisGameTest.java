package kata.tennis.test;
import static org.junit.Assert.assertThat;

import org.junit.Before;

import junit.framework.TestCase;
import kata.tennis.model.Player;
import kata.tennis.model.PlayerGameScore;
import kata.tennis.model.PlayerSetScore;
import kata.tennis.service.TennisGameEngine;
import static org.assertj.core.api.Assertions.*;


public class TennisGameTest extends TestCase{

	
	private TennisGameEngine gameEngine;
    private Player playerOne;
    private Player playerTwo;
    
    private static int POINTS[] = new int[]{0, 15, 30, 40};
	
@Before
public void setUp(){
    gameEngine = new TennisGameEngine();
    
    playerOne = Player.createPlayer("Mouaz Arezki");
    playerTwo = Player.createPlayer("Yannick Noah");
}
	public void testNewGameZeroAll()
	{
		gameEngine.joinGame(playerOne);
        gameEngine.joinGame(playerTwo);
      
        assertThat(gameEngine.getPlayerGameScore(playerOne.getName())).isEqualTo(0);
        assertThat(gameEngine.getPlayerGameScore(playerTwo.getName())).isEqualTo(0);
}

	
	public void testPlayerOneWinsFirst()
	{
		gameEngine.joinGame(playerOne);
        gameEngine.joinGame(playerTwo);
		simulateScore(1,0);

		assertThat(gameEngine.getPlayerGameScore(playerOne.getName())).isEqualTo(15);
        assertThat(gameEngine.getPlayerGameScore(playerTwo.getName())).isEqualTo(0);
	
}
	
	public void testTwoPlayersEquality(){
		gameEngine.joinGame(playerOne);
        gameEngine.joinGame(playerTwo);
		simulateScore(1,1);
		assertThat(gameEngine.getPlayerGameScore(playerOne.getName())).isEqualTo(15);
        assertThat(gameEngine.getPlayerGameScore(playerTwo.getName())).isEqualTo(15);
		
}	
	
	public void testPlayerTwoWinsFirstThirty() {
		gameEngine.joinGame(playerOne);
        gameEngine.joinGame(playerTwo);
		simulateScore(0,2);
		assertThat(gameEngine.getPlayerGameScore(playerOne.getName())).isEqualTo(0);
        assertThat(gameEngine.getPlayerGameScore(playerTwo.getName())).isEqualTo(30);
	
}
	
	public void testPlayerOneWinsFirstFourty(){
		gameEngine.joinGame(playerOne);
        gameEngine.joinGame(playerTwo);
		simulateScore(3,0);
		assertThat(gameEngine.getPlayerGameScore(playerOne.getName())).isEqualTo(40);
        assertThat(gameEngine.getPlayerGameScore(playerTwo.getName())).isEqualTo(0);
	
}
	
	public void testPlayersAreDeuce() {
		gameEngine.joinGame(playerOne);
        gameEngine.joinGame(playerTwo);
		simulateScore(3,3);
	       assertThat(gameEngine.getGameWinner()).isNull();
	        assertThat(gameEngine.isPlayerDeuce(playerOne.getName())).isFalse();
	        assertThat(gameEngine.isPlayerDeuce(playerTwo.getName())).isFalse();
	        gameEngine.winPoint(playerOne.getName());
	        assertThat(gameEngine.getGameWinner()).isNull();
	        assertThat(gameEngine.isPlayerDeuce(playerOne.getName())).isTrue();
	        assertThat(gameEngine.isPlayerDeuce(playerTwo.getName())).isFalse();
	        gameEngine.winPoint(playerTwo.getName());
	        assertThat(gameEngine.getGameWinner()).isNull();
	        assertThat(gameEngine.isPlayerDeuce(playerOne.getName())).isFalse();
	        assertThat(gameEngine.isPlayerDeuce(playerTwo.getName())).isFalse();
	        gameEngine.winPoint(playerTwo.getName());
	        assertThat(gameEngine.getGameWinner()).isNull();
	        assertThat(gameEngine.isPlayerDeuce(playerOne.getName())).isFalse();
	        assertThat(gameEngine.isPlayerDeuce(playerTwo.getName())).isTrue();
	        gameEngine.winPoint(playerTwo.getName());
	        assertThat(gameEngine.getGameWinner()).isEqualTo(playerTwo);	
}
	
	   public void testWinSet() {
	        gameEngine.joinGame(playerOne);
	        gameEngine.joinGame(playerTwo);
	       
	        for (int i=1; i<=6; i++) {
	            for (int j = 0; j < POINTS.length; j++) {
	                assertThat(gameEngine.getPlayerGameScore(playerOne.getName())).isEqualTo(POINTS[j]);
	                assertThat(gameEngine.getPlayerGameScore(playerTwo.getName())).isEqualTo(0);
	                gameEngine.winPoint(playerOne.getName());
	            }
	            assertThat(gameEngine.getGameWinner()).isEqualTo(playerOne);
	            assertThat(gameEngine.getPlayerSetScore(playerOne.getName())).isEqualTo(i);
	            if (i<6)
	                assertThat(gameEngine.getSetWinner()).isNull();
	        }
	        assertThat(gameEngine.getSetWinner()).isEqualTo(playerOne);
	    }
	
	private void simulateScore(int playerOneBalls, int playerTwoBalls ) {
		for (int i = 0; i < playerOneBalls; i++) {
			gameEngine.winPoint(playerOne.getName());
		}
		for (int i = 0; i < playerTwoBalls; i++) {
			gameEngine.winPoint(playerTwo.getName());
		}
		
}
	 
	
	
}
