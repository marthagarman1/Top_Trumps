package db;

public class PlayerDb {

	public PlayerDb(String name, PlayerType type) {
		super();
		this.name = name;
		this.type = type;
	}

	public PlayerDb(int id, String name, PlayerType type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public int id;
	public String name;
	public PlayerType type;
	
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", type=" + type + "]";
	} 
	
}
