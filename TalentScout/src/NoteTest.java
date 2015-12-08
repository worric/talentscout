import static org.junit.Assert.*;
import java.util.Date;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Test;

public class NoteTest {
	
	static int sessionID;
	static int playerID;
	static Note n;
	static Note n2;
	static ScoutingSession s;
	static Player p;
	static Player p2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// sesssion setup
		Date date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		String location = "Skodsborg";
		s = UserInterface.AGENDA.planSession(location, date);
		sessionID = s.getSessionID();
		
		// player setup
		p = UserInterface.PDB.register("Svend", 12, "FC København");
		p2 = UserInterface.PDB.register("Jokum", 12, "FC Skive");
		playerID = p.getID();
		
		// note setup
		String speedText = "Hurtig";
		int speedScore = 6;
		String attitudeText = "God";
		int attitudeScore = 4;
		String techniqueText = "Middelmådig";
		int techniqueScore = 3;
		String gameSenseText = "Står godt på banen";
		int gameSenseScore = 4;
		n = p.addNote(s, speedText, speedScore, attitudeText, attitudeScore,
				techniqueText, techniqueScore, gameSenseText, gameSenseScore);
	}
	
	@Test
	public void testGetSession() {
		ScoutingSession ss = n.getSession();
		
		assertEquals(ss, UserInterface.AGENDA.getSessionByID(sessionID));
	}

	@Test
	public void testSetSession() {
		Date date = UserInterface.DATEMANAGER.fromStringToDate("30-07-2015");
		String location = "Odense";
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		
		n.setSession(ss);
		
		assertEquals(ss, n.getSession());
	}

	@Test
	public void testGetPlayer() {
		Player player = n.getPlayer();
		int pid = player.getID();
		
		assertEquals(player, UserInterface.PDB.getPlayerById(pid));
	}

	@Test
	public void testSetPlayer() {
		n.setPlayer(p2);
		
		assertEquals(p2, n.getPlayer());
	}

	@Test
	public void testGetSpeedText() {
		String speed = n.getSpeedText();
		
		assertEquals("Hurtig", speed);
	}

	@Test
	public void testSetSpeedText() {
		String speed = "Langsom";
		n.setSpeedText(speed);
		
		assertEquals(speed, n.getSpeedText());
	}

	@Test
	public void testGetSpeedScore() {
		int speed = n.getSpeedScore();
		
		assertEquals(6, speed);
	}

	@Test
	public void testSetSpeedScore() {
		int speed = 2;
		
		n.setSpeedScore(speed);
		
		assertEquals(speed, n.getSpeedScore());
	}

	@Test
	public void testGetAttitudeText() {
		String attitude = "Bakker godt op om holdkammerater";
		
		n.setAttitudeText(attitude);
		
		assertEquals(attitude, n.getAttitudeText());
	}

	@Test
	public void testSetAttitudeText() {
		String attitude = "Dårlig";
		
		n.setAttitudeText(attitude);
		
		assertEquals("Dårlig", n.getAttitudeText());
	}

	@Test
	public void testGetAttitudeScore() {
		int attitude = 3;
		
		n.setAttitudeScore(attitude);
		
		assertEquals(attitude, n.getAttitudeScore());
	}

	@Test
	public void testSetAttitudeScore() {
		int attitude = 5;
		
		n.setAttitudeScore(attitude);
		
		assertEquals(attitude, n.getAttitudeScore());
	}

	@Test
	public void testGetTechniqueText() {
		String technique = "Middelmådig";
		
		n.setTechniqueText(technique);
		
		assertEquals(technique, n.getTechniqueText());
	}

	@Test
	public void testSetTechniqueText() {
		String technique = "Forrygende";
		
		n.setTechniqueText(technique);
		
		assertEquals(technique, n.getTechniqueText());
	}

	@Test
	public void testGetTechniqueScore() {
		int technique = 3;
		
		n.setTechniqueScore(technique);
		
		assertEquals(technique, n.getTechniqueScore());
	}

	@Test
	public void testSetTechniqueScore() {
		int technique = 5;
		
		n.setTechniqueScore(technique);
		
		assertEquals(technique, n.getTechniqueScore());
	}

	@Test
	public void testGetGameSenseText() {
		String gameSense = n.getGameSenseText();
		
		assertEquals("Står godt på banen", n.getGameSenseText());
	}

	@Test
	public void testSetGameSenseText() {
		String gameSense = "Står helt forkert på banen";
		
		n.setGameSenseText(gameSense);
		
		assertEquals(gameSense, n.getGameSenseText());
	}

	@Test
	public void testGetGameSenseScore() {
		int gameSense = 5;
		
		n.setGameSenseScore(gameSense);
		
		assertEquals(gameSense, n.getGameSenseScore());
	}

	@Test
	public void testSetGameSenseScore() {
		int gameSense = 1;
		
		n.setGameSenseScore(gameSense);
		
		assertEquals(gameSense, n.getGameSenseScore());
	}
}
