import java.util.ArrayList;

/**
 * The Player class holds information about a Player's name, age and club.
 * It furthermore holds an ArrayList of notes of type Note, which is all the notes written about a Player.
 *  
 * @author Frederik Frode Nygart
 * @author Mikkel Mørch
 * @author Jacob Krag Hansen
 * @author Robin Damsgaard Larsen
 * @author Lotte Selnø
 * @author Bjørn Alsted Nielsen 
 */
public class Player {
	
	/** The Player's name */
	private String name;
	
	/** The Player's age */
	private int age;
	
	/** The Player's club*/
	private String club;
	
	/** An ArrayList "notes" with all the Player's notes */
	private ArrayList <Note> notes;
	
	
	/**
	 * Constructs a new instance of the class Player, and ties up all the 
	 * Player's notes with a new instance of an ArrayList of the type Note 
	 * @param name is a String with the Player's name
	 * @param age is an integer with the Player's age
	 * @param club is a String with the Player's club
	 */
	public Player(String name, int age, String club){
		this.setName(name);
		this.setAge(age);
		this.setClub(club);
		notes = new ArrayList<Note>();
	}
	
	
	/**
	 * Adds an instance of a Note to the ArrayList "notes"
	 * @param note is the Note which is added to "notes" 
	 */
	public void addNote(Note note){
		notes.add(note);
	}
	
	
	/**
	 * Gets a specific Note from the ArrayList "notes"
	 * @param index is the chosen index position in "notes"
	 * @return the Note at the chosen index position
	 */
	public Note getNote(int index){
		return notes.get(index);
	}
	
	
	
	public void displayNote(int index){
		System.out.println(notes.get(index));
	}
	
	public void displayNoteOverview(){
		for(int i = 0; i < notes.size(); i++){
			displayNote(i);
		}
	}
	
	public double displayAverageScore(){
		double totalScore = 0;
		for(int i = 0; i < notes.size(); i++){
			Note report = getNote(i);
			int speed = report.getSpeedScore();
			int attitude = report.getAttitudeScore();
			int technique = report.getTechniqueScore();
			int gameSense = report.getGameSenseScore();
			
			totalScore = totalScore + speed + attitude + technique + gameSense;
		}
		
		System.out.println(totalScore);  
		return totalScore/(notes.size()*4);
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
	
}
