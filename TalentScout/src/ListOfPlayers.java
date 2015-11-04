import java.util.ArrayList;
public class ListOfPlayers {
	
	private ArrayList<Player> playerList;
	
	public ListOfPlayers(){
		this.playerList = new ArrayList<Player>();
	}
	
	public Player getPlayer(String name){
		for(int i = 0; i < playerList.size(); i++){
			if (playerList.get(i).getName().equals(name)){
				return playerList.get(i);
			}
		}
		return null;
	}

}
