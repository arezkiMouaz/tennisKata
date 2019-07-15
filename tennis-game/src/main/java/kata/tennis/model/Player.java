package kata.tennis.model;

import java.util.Objects;

import com.google.common.base.MoreObjects;

public class Player {

	
	


private String name;

private PlayerGameScore gameScore = new PlayerGameScore();
private PlayerSetScore setScore = new PlayerSetScore();



private  Player(String name) {
	
	this.name = name;

}

public static Player createPlayer(
      String name) {
       
        return new Player(name);
    }


final public void resetScores(){
    resetGameScore();
    resetSetScore();
}

final public void resetGameScore(){
    gameScore.clear();
}

final public void resetSetScore(){
    setScore.clear();
}


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}



public PlayerGameScore getGameScore() {
	return gameScore;
}

public void setGameScore(PlayerGameScore gameScore) {
	this.gameScore = gameScore;
}

public PlayerSetScore getSetScore() {
	return setScore;
}

public void setSetScore(PlayerSetScore setScore) {
	this.setScore = setScore;
}


@Override
public int hashCode() {
    return Objects.hash(this.name, this.gameScore,
	this.setScore );
}

@Override
public String toString() {
  return MoreObjects.toStringHelper(this)
    .add( "name", name )
    .add( "gamescore", gameScore ) 
    .add( "setscore", setScore ) 
    .toString();
}
}
