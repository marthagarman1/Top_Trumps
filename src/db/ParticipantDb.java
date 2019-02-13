package db;

public class ParticipantDb {

	public ParticipantDb() {}
	
	public ParticipantDb(PlayerDb player, int roundsWon) {
		super();
		this.player = player;
		this.roundsWon = roundsWon;
	}
	public int id;
	public PlayerDb player;
	public GameResultDb game;
	public int roundsWon;
	
}
