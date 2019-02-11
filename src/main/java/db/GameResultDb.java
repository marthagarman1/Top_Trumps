package db;

import java.util.Collection;


public class GameResultDb {

	public GameResultDb() {}
	
	public GameResultDb(PlayerDb winner, int numberOfRounds, Collection<ParticipantDb> participants) {
		this.winner = winner;
		this.numberOfRounds = numberOfRounds; 
		this.participants = participants;
	}
	
    public int id;
    public PlayerDb winner ;
    public int numberOfRounds; 
    public Collection<ParticipantDb> participants;
    
	@Override
	public String toString() {
		return "GameResult [id=" + id + ", winner=" + winner + ", numberOfRounds=" + numberOfRounds + ", participants="
				+ participants + "]";
	} 
	
}
