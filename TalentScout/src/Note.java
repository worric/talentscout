
public class Note {

	private ScoutingSession session;
	private Player player;
	private String speedText;
	private int speedScore;
	private String attitudeText;
	private int attitudeScore;
	private String techniqueText;
	private int techniqueScore;
	private String gameSenseText;
	private int gameSenseScore;
	
	public Note(ScoutingSession session, Player player){
		this.setSession(session);
		this.setPlayer(player);
	}
	
	public ScoutingSession getSession() {
		return session;
	}

	public void setSession(ScoutingSession session) {
		this.session = session;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
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
