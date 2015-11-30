import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;

public class ScoutingSession implements Serializable, Comparable<ScoutingSession> {
	
	private ArrayList<Integer> spillere;
	private String place;
	private Date date;
	private int sessionID;
	
	public ScoutingSession(String place, Date date, int sessionID){
		spillere = new ArrayList<Integer>();
		this.place = place;
		this.date = date;
		this.sessionID = sessionID;
	}
	
	public void addPlayer(Player player){
		spillere.add(player.getID());
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
	
	public Note makeNote(Player player){
		Note note = new Note(this, player);
		player.addNote(note);
		return note;
	}
	/**
	 * Returns a player based on a certain ID. This ID is fetched from the arraylist "spillere"
	 * and passed as an argument for the getPlayer method of pdb
	 * @param index
	 * @return Player
	 */
	public Player getPlayer(int index){
		return TestScout2.pdb.getPlayerByIndex(spillere.get(index));
	}
	
	public int getNumberOfPlayers(){
		return spillere.size();
	}
	
	public String getPlace(){
		return place;
	}
	
	public void removePlayer(Player player){
		spillere.remove(TestScout2.pdb.getPlayerById(player.getID()));
	}
	
	public void displayPlayer(int index){
		System.out.println(TestScout2.pdb.getPlayerById(spillere.get(index)));
	}

	public void displayPlayerOverview(){
		for(int i = 0; i < spillere.size(); i++){
			System.out.println(TestScout2.pdb.getPlayerById(spillere.get(i)));
		}
	}
	
	public int getSessionID(){
		return sessionID;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public ArrayList<Integer> getList(){
		return spillere;
	}

	@Override
	public int compareTo(ScoutingSession s) {		
		//return this.getDate().compareTo(s.getDate());
		return s.getDate().compareTo(this.getDate());
	}
}
