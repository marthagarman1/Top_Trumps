package commandline;

import java.util.Comparator;


/** 
 * Sorts Players by rounds won from least to greatest. 
 * @author 2402299g
 *
 */
public class PlayerRoundComparator implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		// TODO Auto-generated method stub
		return (o1.getRoundsWon() - o2.getRoundsWon());
	}

}
