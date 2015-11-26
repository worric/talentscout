import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;

public class ScoutingSession implements Serializable {
	
	private ArrayList <Player> players;
	private ArrayList<Integer> spillere;
	private String place;
	private Date date;
	private int sessionID;
	
	public ScoutingSession(String place, Date date, int sessionID){
		// TODO kommenteret ud players = new ArrayList <Player>();
		spillere = new ArrayList<Integer>();
		
		this.place = place;
		this.date = date;
		this.sessionID = sessionID;
	}
	
	public void addPlayer(Player player){
		//players.add(player);
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
		//return players.get(index);
		return PersonligTest.pdb.getPlayerByIndex(spillere.get(index));
		// return PersonligTest.pdb.getPlayerByIndex(spillere.get(index));
	}
	
	public int getNumberOfPlayers(){
		//return players.size();
		return spillere.size();
	}
	
	public String getPlace(){
		return place;
	}
	
	public void removePlayer(Player peter){
		int k = players.indexOf(peter);
		players.remove(k);
	}
	
	public void displayPlayer(int index){
		System.out.println(PersonligTest.pdb.getPlayerById(spillere.get(index)));
	}

	public void displayPlayerOverview(){
		for(int i = 0; i < players.size(); i++){
			displayPlayer(i);
		}
	}
	
	public int getSessionID(){
		return sessionID;
	}
	
	public ArrayList<Player> getList(){
		return players;
	}
}
