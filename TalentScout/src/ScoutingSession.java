import java.util.Date;
import java.util.UUID;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * The ScoutingSession class holds information about the Player Objects associated
 * with a particular ScoutingSession Object, the time and palce of the Scouting Session,
 * as well as a unique ID for the ScoutingSession Object.
 * 
 * The Player Objects associated with the ScoutingSession Object are referenced by the
 * Player Objects' IDs which are hold by an ArrayList.
 * 
 * @author Frederik Frode Nygart
 * @author Mikkel Mørch
 * @author Jacob Krag Hansen
 * @author Robin Damsgaard Larsen
 * @author Lotte Selnø
 * @author Bjørn Alsted Nielsen 
 */

public class ScoutingSession implements Serializable, Comparable<ScoutingSession> {
	
	/** A list of IDs representing Player Objects added to a ScoutingSession*/
	private ArrayList<UUID> players;
	
	/** A ScoutingSession's location*/
	private String location;
	
	/** A ScoutingSession's date*/
	private Date date;
	
	/** A ScoutingSession's ID*/
	private UUID sessionID;
	
	
	/**
	 * Creates a ScoutingSession with an ArrayList of player IDs, a location and a date.
	 * @param location holds the location of the ScoutingSession
	 * @param date holds the date of the ScoutingSession
	 * @param uuid holds the ScoutinSession's unique ID
	 */
	public ScoutingSession(String location, Date date, UUID uuid){
		players = new ArrayList<UUID>();
		this.location = location;
		this.setDate(date);
		this.sessionID = uuid;
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
	 */
	public UUID getSessionID(){
		return sessionID;
	}
	
	/**
	 * Adds a class Player to the ArrayList "players".
	 * @param player is a specific instance of the class Player which should be added
	 * @see #players
	 */
	public void addPlayer(Player player){
		players.add(player.getID());
	}
	
	/**
	 * Gets a Player from the ArrayList "players"
	 * @param index is an integer value which decides the place of action in the ArrayList
	 * @return A player from the index in the ArrayList "players"
	 */
	public Player getPlayer(int index){
		//return TestScout2.pdb.getPlayerById(players.get(index));
		return UserInterface.PDB.getPlayerById(players.get(index));
	}
	
	/**
	 * Returns the number of players associated with a ScoutingSession object
	 * @return The number of players associated with the object
	 */
	public int getNumberOfPlayers(){
		return players.size();
	}
	
	/**
	 * Removes the player from the specific ScoutingSession object
	 * @param player
	 */
	public void removePlayer(Player player){
		/* wraps the integer ID in an object to make us of the remove object function of the ArrayList,
		 * which would otherwise just remove the object at the index provided
		 */
		players.remove(player.getID());
	}
	
	@Override
	public int compareTo(ScoutingSession s) {		
		//return this.getDate().compareTo(s.getDate());
		return s.getDate().compareTo(this.getDate());
	}
}
