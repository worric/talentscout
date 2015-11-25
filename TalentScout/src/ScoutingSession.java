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
		this.setLocation(location);;
		this.setDate(date);
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
	 * Sets a ScoutingSession's location
	 * @param location is of the type String and should be the location of where the ScoutingSession takes place
	 * @see #getLocation()
	 */
	public void setLocation(String location){
		this.location = location;
	}
	
	
	/**
	 * Gets a ScoutingSession's date
	 * @return this ScoutingSessions date
	 * @see #date 
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * Sets a ScoutingSession's date
	 * @param date is of the type Date and should be the exact time of when the ScoutingSession takes place
	 * @see #getDate()
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * @param sessionID is a String which should be an unique ID for this ScoutingSession
	 * @see #getSessionID
	 */
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	
	
	/**
	 * Adds a class Player to the ArrayList "players".
	 * @param player is a specific instance of the class Player which should be added
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
	
	
	/**
	 * Removes a Player from the ArrayList "players"
	 * @param player is a specific instance of the class Player which should be removed
	 */
	public void removePlayer(Player player){
		int index = players.indexOf(player);
		players.remove(index);
	}
	
	
	/**
	 * Displays a Player from the ArrayList players
	 * @param index is an integer value which decides the place of action in the ArrayList
	 */
	public void displayPlayer(int index){
		System.out.println(players.get(index));
	}

	
	/**
	 * Displays an entire overview of Player objects in the ArrayList "players" 
	 */
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
