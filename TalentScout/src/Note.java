import java.io.Serializable;
import java.util.UUID;

/** The Note class holds information about a Player's performance in a Scouting Session.
 * The class is responsible for getting and setting information of a Player's performance
 * in a Scouting Session. It is Serializable as it contains user information which is to be
 * saved as data, which can be displayed for the user whenever he wishes.
 * 
 * @author Frederik Frode Nygart
 * @author Mikkel Mørch
 * @author Jacob Krag Hansen
 * @author Robin Damsgaard Larsen
 * @author Lotte Selnø
 * @author Bjørn Alsted Nielsen 
 */

public class Note implements Serializable {

	private UUID sessionID;
	private UUID playerID;
	private String speedText;
	private int speedScore;
	private String attitudeText;
	private int attitudeScore;
	private String techniqueText;
	private int techniqueScore;
	private String gameSenseText;
	private int gameSenseScore;

	public Note(ScoutingSession session, Player player,
		String speedText, int speedScore,
		String attitudeText, int attitudeScore,
		String techniqueText, int techniqueScore,
		String gameSenseText, int gameSenseScore){
		this.sessionID = session.getSessionID();
		this.playerID = player.getID();
		this.speedText = speedText;
		this.speedScore = speedScore;
		this.attitudeText = attitudeText;
		this.attitudeScore = attitudeScore;
		this.techniqueText = techniqueText;
		this.techniqueScore = techniqueScore;
		this.gameSenseText = gameSenseText;
		this.gameSenseScore = gameSenseScore;
	}
        
        /**
         * Getter for the ScoutingSession object itself.
         * @return A ScoutingSession object.
         */
	public ScoutingSession getSession() {
		return UserInterface.AGENDA.getSessionByID(this.sessionID);
	}

	public void setSession(ScoutingSession session) {
		this.sessionID = session.getSessionID();
	}
	
	public Player getPlayer() {
		return UserInterface.PDB.getPlayerById(playerID);
	}

	public void setPlayer(Player player) {
		this.playerID = player.getID();
	}

	public String getSpeedText() {
		return speedText;
	}

	public void setSpeedText(String speedText) {
		this.speedText = speedText;
	}

	public int getSpeedScore() {
		return speedScore;
	}

	public void setSpeedScore(int speedScore) {
		this.speedScore = speedScore;
	}

	public String getAttitudeText() {
		return attitudeText;
	}

	public void setAttitudeText(String attitudeText) {
		this.attitudeText = attitudeText;
	}

	public int getAttitudeScore() {
		return attitudeScore;
	}

	public void setAttitudeScore(int attitudeScore) {
		this.attitudeScore = attitudeScore;
	}

	public String getTechniqueText() {
		return techniqueText;
	}

	public void setTechniqueText(String techniqueText) {
		this.techniqueText = techniqueText;
	}

	public int getTechniqueScore() {
		return techniqueScore;
	}

	public void setTechniqueScore(int techniqueScore) {
		this.techniqueScore = techniqueScore;
	}

	public String getGameSenseText() {
		return gameSenseText;
	}

	public void setGameSenseText(String gameSenseText) {
		this.gameSenseText = gameSenseText;
	}

	public int getGameSenseScore() {
		return gameSenseScore;
	}

	public void setGameSenseScore(int gameSenseScore) {
		this.gameSenseScore = gameSenseScore;
	}
}
