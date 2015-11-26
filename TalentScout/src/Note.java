import java.io.Serializable;

public class Note implements Serializable {
	
	private int sessionID;
	private int playerID;
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
	
	public Note(ScoutingSession session, Player player){
		this(session, player, "", 0, "", 0, "", 0, "", 0);
	}
	
	public ScoutingSession getSession() {
		return PersonligTest.a.getSessionByID(sessionID);
	}

	public void setSession(ScoutingSession session) {
		this.sessionID = session.getSessionID();
	}
	
	public Player getPlayer() {
		return PersonligTest.pdb.getPlayerById(playerID);
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
	
	public void printNote(){
		System.out.println("Name: "+PersonligTest.pdb.getPlayerById(playerID).getName()+":");
		System.out.println("Session: "+PersonligTest.a.getSessionByID(sessionID).getPlace());
		System.out.println("Speed: "+speedText+", "+speedScore+".");
		System.out.println("Attitude: "+attitudeText+", "+attitudeScore+".");
		System.out.println("Technique: "+techniqueText+", "+techniqueScore+".");
		System.out.println("Game Sense: "+gameSenseText+", "+gameSenseScore+".");
	}

}
