import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;

public class ScoutingSession implements Serializable {
	
	private ArrayList <Player> players;
	private String place;
	private Date date;
	private String sessionID;
	
	public ScoutingSession(String place, Date date, String sessionID){
		players = new ArrayList <Player>();
		this.place = place;
		this.date = date;
		this.setSessionID(sessionID);
	}
	
	public void addPlayer(Player player){
		players.add(player);
	}
	
	public Note makeNote(Player player){
			Note note = new Note(this, player);
			player.addNote(note);
			return note;
	}
	
	public Player getPlayer(int index){
		return players.get(index);
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
	
	public String getSessionID(){
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	
	public ArrayList<Player> getList(){
		return players;
	}
	
	

}
