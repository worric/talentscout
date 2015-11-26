import java.io.Serializable;
import java.util.ArrayList;


public class Player implements Serializable {
	
	private int playerID;
	private String name;
	private int age;
	private String club;
	private ArrayList <Note> notes;
	private boolean isActive; //TODO may be renamed to reflect "player discarded"
	
	public enum Parameters {SPEED, ATTITUDE, TECHNIQUE, GAMESENSE};
	
	
	public Player(String name, int age, String club, int id){
		this.setName(name);
		this.setAge(age);
		this.setClub(club);
		this.playerID = id;
		this.isActive = true;
		notes = new ArrayList<Note>();
	}
	
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
	
	public Note addNote(Note note){
		notes.add(note);
		return note;
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
	
	public double getAverage(Parameters parameters){ // TODO lav videre på denne case...
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
			default:
				return 0;
			}
		} else {
			return 0;
		}
		
		
	}
	
	/**
	 * Changed this method to check if any notes have been made before doing the calculation
	 * @return
	 */
	public double displayAverageScore(){
		double totalScore = 0;
		double totalSpeed = 0;
		double totalAttitude = 0;
		double totalTechnique = 0;
		double totalGameSense = 0;
		
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
	
	public int getID(){
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
	
}
