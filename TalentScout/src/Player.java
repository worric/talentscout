import java.io.Serializable;
import java.util.ArrayList;


public class Player implements Serializable {
	
	private String name;
	private int age;
	private String club;
	private String id;
	private ArrayList <Note> notes;
	
	
	public Player(String name, int age, String club, String id){
		this.setName(name);
		this.setAge(age);
		this.setClub(club);
		this.id = id;
		notes = new ArrayList<Note>();
	}
	
	public void addNote(Note note){
		notes.add(note);
	}
	
	public Note getNote(int index){
		return notes.get(index);
	}
	/**
	 * Adds the functionality to check the size of the ArrayList
	 * used in interations in other classes
	 * @return
	 */
	public int getNumberOfNotes(){
		return notes.size();
	}
	
	public void displayNote(int index){
		System.out.println(notes.get(index));
	}
	
	public void displayNoteOverview(){
		for(int i = 0; i < notes.size(); i++){
			displayNote(i);
		}
	}
	/**
	 * Changed this method to check if any notes have been made before doing the calculation
	 * @return
	 */
	public double displayAverageScore(){
		double totalScore = 0;
		
		if(notes.size() > 0){
			for(int i = 0; i < notes.size(); i++){
				Note report = getNote(i);
				int speed = report.getSpeedScore();
				int attitude = report.getAttitudeScore();
				int technique = report.getTechniqueScore();
				int gameSense = report.getGameSenseScore();
				
				totalScore = totalScore + speed + attitude + technique + gameSense;
			}
		} else {
			return totalScore;
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
	
	public String getID(){
		return this.id;
	}
	
}
