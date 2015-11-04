import java.util.ArrayList;
import java.util.Date;
public class Player {
	
	private String name;
	private static int idCounter = 0;
	private int id;
	private String noteGeneral;
	private boolean active;
	private ArrayList<ScoutingSession> sessions; // TODO evt implementer en helper class der kan styre tilgangen til objekter
	private Date discoveredDate;
	private Date undiscoveredDate;
	private boolean isDiscovered;
	
	/**
	 * Constructor.
	 * @param name
	 * @param id
	 * @param note
	 */
	public Player(String name, String note, ScoutingSession s){
		this.name = name;
		this.id = idCounter;
		idCounter++;
		this.active = true;
		this.sessions = new ArrayList<ScoutingSession>();
		this.sessions.add(s);
		this.discoveredDate = new Date();
		this.isDiscovered = true;
	} //Constructer slut
	
	/**
	 * default constructor
	 */
	public Player(){
		this("ikke-navngivet", "tom", null);
	} // Default constructor slut
	
	/**
	 * Testfunktion til at skrive en note til et playerobjekt.
	 * @param note
	 */
	public void setNote(String note){
		this.noteGeneral = note;
	}
	/**
	 * testfuntion til at læse en note fra et playerobjekt.
	 * @return
	 */
	public String getNote(){
		return this.noteGeneral;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setInactive(){
		this.active = false;
	}
	
	public void setActive(){
		this.active = true;
	}
	
	public void addScoutingSession(ScoutingSession s){
		this.sessions.add(s);
	}
	
	public void removeScoutingSession(int id){
		this.sessions.remove(id);
	}
	
	public void removeScoutingSession(ScoutingSession s){
		ScoutingSession session = s;
		
		sessions.remove(s);
		
	}
	
	public ScoutingSession getScoutingSession(int i){
		return sessions.get(i);
	}
	
	public String getName(){
		return this.name;
	}
	

}
