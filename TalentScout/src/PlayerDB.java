import java.util.ArrayList;
public class PlayerDB {
	
	private ArrayList<Player> playerDB;
	
	public PlayerDB(){
		playerDB = new ArrayList<Player>();
	}
	
	public void addPlayer(Player p){
		playerDB.add(p);
	}
	
	public void removePlayer(Player p){
		playerDB.remove(p);
	}
	
	public Player getPlayer(int i){
		return playerDB.get(i);
	}
	
	
	public int getSize(){
		return playerDB.size();
	}
	
	public Player findPlayer(String name){
		for(Player p : playerDB){
			if(p.getName().equals(name)){
				return p;
			}
		}
		return null;
	}

}
