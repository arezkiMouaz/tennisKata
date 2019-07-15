package kata.tennis.service;


import java.util.HashMap;
import java.util.Map;

import kata.tennis.model.ITennisGame;
import kata.tennis.model.Player;


public class TennisGameEngine implements ITennisGame{
	
	private final Map<String, Player> players = new HashMap<String, Player>();

    private GameProcessor gameScoreProcessor = new GameProcessor(this);
    private SetProcessor setScoreProcessor = new SetProcessor(this);
    
    
    
    private Player pointWinner;
    
    private Player gameWinner;
    
    private Player setWinner;
    
    private Player matchWinner;

    
    public void joinGame(Player player) {
        if (players.size()<2)
            players.put(player.getName(), player);
        else
            throw new RuntimeException("Game is full");
    }
    
    private void clearWinners() {
        setPointWinner(null);
        setGameWinner(null);
        setSetWinner(null);
        setMatchWinner(null);
}

   
    @Override
    public void winPoint(String name) {
        clearWinners();
        Player player=getPlayer(name);
        String opponentName=getOpponentName(name);
        Player opponent=getPlayer(opponentName);
        setPointWinner(player);
        gameScoreProcessor.process(player, opponent);
}

	@Override
	public void winTheGame(String name) {
		Player player=getPlayer(name);
        String opponentName=getOpponentName(name);
        Player opponent=getPlayer(opponentName);
		setGameWinner(player);
		setScoreProcessor.process(player, opponent);
		resetGameScores();
		
	}

	@Override
	public void winTheSet(String name) {
		setSetWinner(getPlayer(name));
		
	}

	@Override
	public void winTheMatch(String name) {
		setMatchWinner(getPlayer(name));
		
	}

	@Override
	public String getPlayerName(String name) {
		return getPlayer(name).getName();
	}

	@Override
	public int getPlayerGameScore(String name) {
		return getPlayer(name).getGameScore().getScore();
	}

	@Override
	public int getPlayerSetScore(String name) {
		return getPlayer(name).getSetScore().getScore();
	}

	@Override
	public boolean isPlayerDeuce(String name) {
		return getPlayer(name).getGameScore().isDeuce();
	}

	@Override
	public void setPlayerDeuce(Player player, boolean deuce) {
		player.getGameScore().setDeuce(deuce);
		
	}

	@Override
	public void setPlayerGameScore(Player player, int score) {
		player.getGameScore().setScore(score);
		
	}

	@Override
	public void setPlayerSetScore(Player player, int score) {
		player.getSetScore().setScore(score);
		
	}

	@Override
	public Player getGameWinner() {
	
		return gameWinner;
	}

	@Override
	public Player getSetWinner() {
		
		return setWinner;
	}

	@Override
	public void resetGameScores() {
		for(Player player: players.values())
            if (player!=null)
player.resetGameScore();
		
	}

	@Override
	public void resetSetScores() {
		for(Player player: players.values())
			player.resetSetScore();
		
	}

	@Override
	public void clearPlayers() {
		players.clear();
		
	}

	@Override
	public int getPlayerTieBreakScore(String name) {
		 return getPlayer(name).getSetScore().getTieBreak();
	}

	@Override
	public void setPlayerTieBreakScore(String name, int score) {
		getPlayer(name).getSetScore().setTieBreak(score);
		
	}
	
	 private Player getPlayer(String name) {
	        Player player = players.get(name);
	        if (player==null)
	            throw new RuntimeException("Player not founds");
	        return player;
	}


	public Player getPointWinner() {
		return pointWinner;
	}


	public void setPointWinner(Player pointWinner) {
		this.pointWinner = pointWinner;
	}


	public void setGameWinner(Player gameWinner) {
		this.gameWinner = gameWinner;
	}


	public void setSetWinner(Player setWinner) {
		this.setWinner = setWinner;
	}
	
	 public String getOpponentName(String name) {
	        for (String playerName : players.keySet().toArray(new String[0])) {
	            if (!playerName.equals(name))
	                return playerName;
	        }
	        return null;
	}


	public Player getMatchWinner() {
		return matchWinner;
	}


	public void setMatchWinner(Player matchWinner) {
		this.matchWinner = matchWinner;
	}

	public GameProcessor getGameScoreProcessor() {
		return gameScoreProcessor;
	}

	public void setGameScoreProcessor(GameProcessor gameScoreProcessor) {
		this.gameScoreProcessor = gameScoreProcessor;
	}

	public SetProcessor getSetScoreProcessor() {
		return setScoreProcessor;
	}

	public void setSetScoreProcessor(SetProcessor setScoreProcessor) {
		this.setScoreProcessor = setScoreProcessor;
	}

	public Map<String, Player> getPlayers() {
		return players;
	}
	
}
