package db;

/**
 * An object representing a data model of a single row from `participant` sql table.
 * Also represents many-to-one relations with `user` and `game` tables through {@link PlayerDb} and {@link GameResultDb}
 * objects correspondingly
 */
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
