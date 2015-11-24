import java.util.Date;
import java.util.ArrayList;

/**
 * The ScoutingSession class holds an ArrayList of the class Player that are added to a ScoutingSession. 
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
	
	/** A list of the class Player added to a ScoutingSession*/
	private ArrayList <Player> players;
	
	/** A ScoutingSession's location*/
	private String location;
	
	/** A ScoutingSession's date*/
	private Date date;
	
	/** A ScoutingSession's ID*/
	private String sessionID;
	
	
	/**
	 * Creates a ScoutingSession with an ArrayList "players", a location and a date.
	 * @param location holds the location of the ScoutingSession
	 * @param date holds the date of the ScoutingSession
	 * @param sessionID holds the ScoutinSession's unique ID
	 */
	public ScoutingSession(String location, Date date, String sessionID){
		players = new ArrayList <Player>();
		this.location = location;
		this.date = date;
		this.setSessionID(sessionID);
	}
	
	
	/**
	 * Gets a ScoutingSession's location
	 * @return this ScoutingSessions location
	 * @see #location 
	 */
	public String getLocation(){
		return location;
	}
	
	
	/**
	 * Gets a ScoutingSession's ID
	 * @return the ScoutingSession's ID
	 * @see #setSessionID(String)
	 */
	
	public String getSessionID(){
		return sessionID;
	}

	/**
	 * Sets a ScoutingSession's ID
	 * @param sessionID is a unique ID for this ScoutingSession
	 * @see #getSessionID
	 */
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	
	
	/**
	 * Adds a class Player to the ArrayList "players".
	 * @param player is a generic instance of the class Player
	 * @see #players
	 */
	public void addPlayer(Player player){
		players.add(player);
	}
	
	
	/**
	 * Gets a Player from the ArrayList "players"
	 * @param index is an integer value which decides the place of action in the ArrayList
	 * @return A player from the index in the ArrayList "players"
	 */
	public Player getPlayer(int index){
		return players.get(index);
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
	
	
	/**
	 * Creates a new note and adds it to the ArrayList "notes" in the class Player
	 * @param player is a generic instance of the class Player
	 * @return The Note with this ScoutingSession and the Player stated in the parameter
	 */
	public Note makeNote(Player player){
			Note note = new Note(this, player);
			player.addNote(note);
			return note;
	}
	

}
