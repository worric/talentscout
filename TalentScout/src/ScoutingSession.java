import java.util.Date;
import java.util.ArrayList;

/**
 * The ScoutingSession class holds a list of players that are added to a ScoutingSession. 
 * Further it holds information about a specific ScoutingSession's location and date.
 * 
 * @author Frederik Frode Nygart
 * @author Mikkel Mørch
 * @author Jacob Krag Hansen
 * @author Robin Damsgaard Larsen
 * @author Lotte Selnø
 * @author Bjørn Alsted Nielsen 
 */

public class ScoutingSession {
	
	private ArrayList <Player> players;
	private String location;
	private Date date;
	private String sessionID;
	
	public ScoutingSession(String location, Date date, String sessionID){
		players = new ArrayList <Player>();
		this.location = location;
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
	
	public String getLocation(){
		return location;
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
	
	

}
