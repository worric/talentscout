import java.util.Date;
import java.io.Serializable;
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

public class ScoutingSession implements Serializable, Comparable<ScoutingSession> {
	
	/** A list of the class Player added to a ScoutingSession*/
	private ArrayList<Integer> players;
	
	/** A ScoutingSession's location*/
	private String location;
	
	/** A ScoutingSession's date*/
	private Date date;
	
	/** A ScoutingSession's ID*/
	private int sessionID;
	
	
	/**
	 * Creates a ScoutingSession with an ArrayList of player IDs, a location and a date.
	 * @param location holds the location of the ScoutingSession
	 * @param date holds the date of the ScoutingSession
	 * @param sessionID holds the ScoutinSession's unique ID
	 */
	public ScoutingSession(String location, Date date, int sessionID){
		players = new ArrayList<Integer>();
		this.location = location;
		this.setDate(date);
		this.sessionID = sessionID;
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
	
	public int getSessionID(){
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
	
	public int getNumberOfPlayers(){
		return players.size();
	}
	
	public Note addNote(Player player,
			String speedText, int speedScore,
			String attitudeText, int attitudeScore,
			String techniqueText, int techniqueScore,
			String gameSenseText, int gameSenseScore){
		
		// Construct a new note from the arguments passed
		Note n = new Note(this, player,
				speedText, speedScore,
				attitudeText, attitudeScore,
				techniqueText, techniqueScore,
				gameSenseText, gameSenseScore);
		
		player.addNote(n);
		return n;
	}
	
	
	public void removePlayer(Player player){
		/* wraps the integer ID in an object to make us of the remove object function of the ArrayList,
		 * which would otherwise just remove the object at the index provided
		 */
		players.remove(new Integer(player.getID()));
	}
	
	/**
	 * Creates a new note and adds it to the ArrayList "notes" in the class Player
	 * @param player is a generic instance of the class Player
	 * @return The Note with this ScoutingSession and the Player stated in the parameter
	 */
	public Note makeNote(Player player){ // TODO ved ikke om den er overflødig.
			Note note = new Note(this, player);
			player.addNote(note);
			return note;
	}
	
	@Override
	public int compareTo(ScoutingSession s) {		
		//return this.getDate().compareTo(s.getDate());
		return s.getDate().compareTo(this.getDate());
	}
}
