import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;

public class ScoutingSession implements Serializable {
	
	private PlayerDB pdb;
	private ArrayList <Player> players;
	private ArrayList<Integer> spillere;
	private String place;
	private Date date;
	private int sessionID;
	
	public ScoutingSession(String place, Date date, int sessionID){
		players = new ArrayList <Player>();
		spillere = new ArrayList<Integer>();
		this.pdb = pdb; // TODO ret constructoren 
		this.place = place;
		this.date = date;
		this.sessionID = sessionID;
	}
	
	public void addPlayer(Player player){
		//players.add(player);
		spillere.add(player.getID());
	}
	
	public Note makeNote(Player player){
		Note note = new Note(this, player);
		player.addNote(note);
		return note;
	}
	/**
	 * Returns a player based on a certain ID. This ID is fetched from the arraylist "spillere"
	 * and passed as an argument for the getPlayer method of pdb
	 * @param index
	 * @return Player
	 */
	public Player getPlayer(int index){
		//return players.get(index);
		return pdb.getPlayerByIndex(spillere.get(index));
	}
	
	public int getNumberOfPlayers(){
		return players.size();
	}
	
	public String getPlace(){
		return place;
	}
	
	public void removePlayer(Player peter){
		int k = players.indexOf(peter);
		players.remove(k);
	}
	
	public void displayPlayer(int index){
		System.out.println(players.get(index));
	}

	public void displayPlayerOverview(){
		for(int i = 0; i < players.size(); i++){
			displayPlayer(i);
		}
	}
	
	public int getSessionID(){
		return sessionID;
	}

	/*public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}*/
	
	public ArrayList<Player> getList(){
		return players;
	}
	
	

}
