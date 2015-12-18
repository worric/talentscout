import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;

/**
 * The Player class holds information about a Player's name, age and club
 * as well as a unique ID for the Player object.
 * Furthermore, it holds an ArrayList of notes of type Note, which is all the notes written about a Player.
 *  
 * @author Frederik Frode Nygart
 * @author Mikkel Mørch
 * @author Jacob Krag Hansen
 * @author Robin Damsgaard Larsen
 * @author Lotte Selnø
 * @author Bjørn Alsted Nielsen 
 */
public class Player implements Serializable {

	/** The Player's name */
	private String name;
	
	/** The Player's age */
	private int age;
	
	/** The Player's club*/
	private String club;
	
	/** An ArrayList "notes" with all the Player's notes */
	private ArrayList <Note> notes;
	
	// Player's ID
	private UUID playerID;
	
	// Track if the player is active or not
	private boolean isActive;
	
	// Initializes an enum with the four parameters
	public enum Parameters {SPEED, ATTITUDE, TECHNIQUE, GAMESENSE, ALL};
	
	/**
	 * Constructs a new instance of the class Player, and ties up all the 
	 * Player's notes with a new instance of an ArrayList of the type Note 
	 * @param name is a String with the Player's name
	 * @param age is an integer with the Player's age
	 * @param club is a String with the Player's club
	 */
	public Player(String name, int age, String club, UUID uuid){
		this.setName(name);
		this.setAge(age);
		this.setClub(club);
		this.playerID = uuid;
		this.isActive = true;
		notes = new ArrayList<Note>();
	}
	
        /** Creates a Note which contains information about a Player's performance in a specific ScoutingSession.
         * 
         * @param session the ScoutingSession associated with the Note
         * @param speedText a description of Player's performance in regard to his speed.
         * @param speedScore a score of Player's performance in regard to his speed.
         * @param attitudeText a description of Player's performance in regard to his attitude.
         * @param attitudeScore a score of Player's performance in regard to his attitude.
         * @param techniqueText a description of Player's performance in regard to his technique.
         * @param techniqueScore a score of Player's performance in regard to his technique.
         * @param gameSenseText a description of Player's performance in regard to his gamesense.
         * @param gameSenseScore a score of Player's performance in regard to his gamesense.
         * @return a Note object
         */
	public Note addNote(ScoutingSession session,
			String speedText, int speedScore,
			String attitudeText, int attitudeScore,
			String techniqueText, int techniqueScore,
			String gameSenseText, int gameSenseScore){
		
		// Construct a new note from the arguments passed
		Note n = new Note(session, this,
				speedText, speedScore,
				attitudeText, attitudeScore,
				techniqueText, techniqueScore,
				gameSenseText, gameSenseScore);
		
		notes.add(n);
		return n;
	}
	
	/**
	 * Gets a specific Note from the ArrayList "notes"
	 * @param index is the chosen index position in "notes"
	 * @return the Note at the chosen index position
	 */
	public Note getNote(int index){
		return notes.get(index);
	}
	/**
	 * Adds the functionality to check the size of the ArrayList
	 * used for iteration in other classes
	 * @return
	 */
	public int getNumberOfNotes(){
		return notes.size();
	}
        
	/**
	 * Get the average score from all notes owned by the player based on a single parameter
	 */
	public double getAverage(Parameters parameters){
		if(!notes.isEmpty()){
			int j;
			switch(parameters){
			case SPEED:
				double totalSpeed = 0;
				j = 0;
				for(int i = 0; i < notes.size(); i++){
					if(notes.get(i).getSpeedScore() != 0){
						j++;
						totalSpeed = totalSpeed + notes.get(i).getSpeedScore();
					}
				}
				return totalSpeed/j;
			case ATTITUDE:
				double totalAttitude = 0;
				j = 0;
				for(int i = 0; i < notes.size(); i++){
					if(notes.get(i).getAttitudeScore() != 0){
						j++;
						totalAttitude = totalAttitude + notes.get(i).getAttitudeScore();
					}
				}
				return totalAttitude/j;
			case TECHNIQUE:
				double totalTechnique = 0;
				j = 0;
				for(int i = 0; i < notes.size(); i++){
					if(notes.get(i).getTechniqueScore() != 0){
						j++;
						totalTechnique = totalTechnique + notes.get(i).getTechniqueScore();
					}
				}
				return totalTechnique/j;
			case GAMESENSE:
				double totalGameSense = 0;
				j = 0;
				for(int i = 0; i < notes.size(); i++){
					if(notes.get(i).getGameSenseScore() != 0){
						j++;
						totalGameSense = totalGameSense + notes.get(i).getGameSenseScore();
					}
				}
				return totalGameSense/j;
            case ALL:
                return (this.getAverage(Player.Parameters.SPEED)+
                		this.getAverage(Player.Parameters.ATTITUDE)+
                		this.getAverage(Player.Parameters.TECHNIQUE)+
                		this.getAverage(Player.Parameters.GAMESENSE))/4;
            default:
				return 0.0;
			}
		} else {
			return 0.0;
		}
	}
        
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}
	
	public UUID getID(){
		return this.playerID;
	}
	
	public void setInactive(){
		if(!this.isActive == false){
			this.isActive = false;
		}
	}
	
	public void setActive(){
		if(!this.isActive == true){
			this.isActive = true;
		}
	}
	
	public boolean getActiveState(){
		return isActive;
	}
	
}
