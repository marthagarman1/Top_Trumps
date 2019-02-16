package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;



public class GameResultRepository {

	private final DbDriver driver;

	public GameResultRepository(DbDriver driver) {
		this.driver = driver;
	}

	/**
	 * selects and
	 * @return max number of rounds
	 * @throws SQLException, IllegalStateException
	 *
	 */


	public int getLargestNumberOfRounds() throws SQLException { 
		Connection con = driver.getConnection();
		try {
			
			ResultSet result = con.prepareStatement("SELECT max(numberOfRounds) FROM game_result").executeQuery();
			
		    if (!result.next()) {
		    	throw new IllegalStateException("Sql returned no rows");
		    }
		    
		    return result.getInt(1);
			
		} finally {
			con.close();
		}
	}

	/**
	 * selects and
	 * @return number of rounds where the winner is null
	 * @throws SQLException, IllegalStateException
	 *
	 */



	public int getNumberOfDraws() throws SQLException { 
		Connection con = driver.getConnection();
		try {
			
			ResultSet result = con.prepareStatement("SELECT count(*) FROM game_result WHERE winner IS NULL").executeQuery();
			
		    if (!result.next()) {
		    	throw new IllegalStateException("Sql returned no rows");
		    }
		    
		    return result.getInt(1);
			
		} finally {
			con.close();
		}
	}

	/**
	 * selects and
	 * @return the number of games won based on player type
	 * @throws SQLException, IllegalStateException
	 *
	 */


	public int getWinsByPlayerType(PlayerType type) throws SQLException {
		Connection con = driver.getConnection();
		try {
			
			PreparedStatement statement = con.prepareStatement("SELECT count(*) FROM game_result as G JOIN PLAYER AS P ON G.winner = P.id WHERE p.type = ?");
					 
			statement.setString(1, type.name());
			
			ResultSet result = statement.executeQuery(); 
			
		    if (!result.next()) {
		    	throw new IllegalStateException("Sql returned no rows");
		    }
		    
		    return result.getInt(1);
			
		} finally {
			con.close();
		}
	}

	/**
	 * selects and
	 * @return number of total games
	 * @throws SQLException, IllegalStateException
	 *
	 */



	public int totalGames() throws SQLException {
		Connection con = driver.getConnection();
		try {
			
			ResultSet result = con.prepareStatement("SELECT count(*) FROM game_result").executeQuery();
			
		    if (!result.next()) {
		    	throw new IllegalStateException("Sql returned no rows");
		    }
		    
		    return result.getInt(1);
			
		} finally {
			con.close();
		}
	}
	
	/**
	 *
	 * @param
	 * @return
	 * @throws SQLException
	 * 
	 *
	 */

	public int save(GameResultDb game) throws SQLException {
		validate(game);

		int id;
		Connection con = driver.getConnection();
		try {
			con.setAutoCommit(false); // nekuriame atskiru transakciju kiekvienam query

			PreparedStatement createGameStatement = con.prepareStatement(
					"INSERT INTO  game_result (winner,numberOfRounds) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS); //cia pasizymime, kad grazintu ID is viso

			// Null means a draw
			if (game.winner != null) {
			    createGameStatement.setInt(1, game.winner.id);
			} else {
				createGameStatement.setNull(1, Types.INTEGER);
			}
			createGameStatement.setInt(2, game.numberOfRounds); 

			createGameStatement.executeUpdate(); //insertinam nauja zaidima

			ResultSet result = createGameStatement.getGeneratedKeys();//grazina tik ka sukurta ID naujai insertinto object

		    if (!result.next()) {//tikriname, ar grazino ID, nes jei ne, tai npavyko suinsertinti objekto.
		    	throw new IllegalStateException("Sql returned no rows");
		    } 
			id = result.getInt(1); //is grazinto table pasiimame ID reiksme
			
			for (ParticipantDb participant : game.participants) {

				PreparedStatement createParticipantStatement = con.prepareStatement(
						"INSERT INTO  participation (roundsWon,playerId,gameId) VALUES (?, ?, ?)" );
				createParticipantStatement.setInt(1, participant.roundsWon); 
			    createParticipantStatement.setInt(2, participant.player.id);  
				createParticipantStatement.setInt(3, id); 
				createParticipantStatement.executeUpdate();
			}
			
			con.commit();

			return id;
			
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			con.close();
		} 
 
	}



	/*
	Method validates entry values so number of rounds is not less than one, there are at least 2 participants
	in the game and
	 */



	private void validate(GameResultDb results) {
		if (results.numberOfRounds < 1) {
			throw new IllegalArgumentException("Game must have at least one round");
		} 
		if (results.participants == null || results.participants.size() < 2) {
			throw new IllegalArgumentException("Game must have at least two players");
		}
	}

}
