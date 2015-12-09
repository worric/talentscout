import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NoteTest {
	
	static String name;
	static int age;
	static String club;
	
	static Date date;
	static String location;
	
	static String speedText;
	static int speedScore;
	static String attitudeText;
	static int attitudeScore;
	static String techniqueText;
	static int techniqueScore;
	static String gameSenseText;
	static int gameSenseScore;
	
	/*static int sessionID;
	static int playerID;
	static Note n;
	static Note n2;
	static ScoutingSession s;
	static Player p;
	static Player p2;*/

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// sesssion setup
		date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		location = "Skodsborg";
		
		// player setup
		name = "Karl";
		age = 14;
		club ="Aab";
		
		// note setup
		speedText = "Hurtig";
		speedScore = 6;
		attitudeText = "God";
		attitudeScore = 4;
		techniqueText = "Middelmådig";
		techniqueScore = 3;
		gameSenseText = "Står godt på banen";
		gameSenseScore = 4;
		
		//s = UserInterface.AGENDA.planSession(location, date);
		//sessionID = s.getSessionID();
		
		// player setup
		//p = UserInterface.PDB.register("Svend", 12, "FC København");
		//p2 = UserInterface.PDB.register("Jokum", 12, "FC Skive");
		//playerID = p.getID();
		
		// note setup
		
		//n = p.addNote(s, speedText, speedScore, attitudeText, attitudeScore,
		//		techniqueText, techniqueScore, gameSenseText, gameSenseScore);
	}
	
	@Before
	public void setUp() throws Exception {
		// setup a default scouting session to be used in some of the tests
		UserInterface.AGENDA.planSession(location, date);
	}
	
	@After
	public void tearDown() throws Exception {
		// clear the arraylist of players
		UserInterface.PDB.getArrayListPlayer().clear();
		
		// clear the Agenda list of scouting sessions
		// define a new arraylist
		ArrayList<ScoutingSession> list = new ArrayList<ScoutingSession>();
		// populate it with the same objects as the one in the agenda class
		for(int i = 0; i < UserInterface.AGENDA.getNumberOfSessions(); i++){
			ScoutingSession ss = UserInterface.AGENDA.getSessionByIndex(i);
			list.add(ss);
		}
		// remove all the objects
		for(ScoutingSession ss : list){
			UserInterface.AGENDA.cancelSession(ss);
		}
	}
	
	@Test
	public void testGetSession() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		assertEquals(ss, n.getSession());
	}

	@Test
	public void testSetSession() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);

		// create a new session and change it on the note
		Date date = UserInterface.DATEMANAGER.fromStringToDate("30-07-2015");
		String location = "Odense";
		ScoutingSession ss2 = UserInterface.AGENDA.planSession(location, date);
		n.setSession(ss2);
		
		// check if the new one matches
		assertEquals(ss2, n.getSession());
	}

	@Test
	public void testGetPlayer() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		// get the player from the note and assign it to a new variable 
		Player p2 = n.getPlayer();
		
		// check if they're equal
		assertEquals(p, p2);
	}

	@Test
	public void testSetPlayer() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		// setup a new player
		String name = "Haakon";
		int age = 19;
		String club = "FC København";
		Player p2 = UserInterface.PDB.register(name, age, club);
		
		// set the new player on the note
		n.setPlayer(p2);
		
		// check if they're equal
		assertEquals(p2, n.getPlayer());
	}

	@Test
	public void testGetSpeedText() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		// check if equals. We know from the setup that speed text is "Hurtig"
		assertEquals("Hurtig", n.getSpeedText());
	}

	@Test
	public void testSetSpeedText() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		// setup new speed text and change it on the note
		String speed = "Langsom";
		n.setSpeedText(speed);
		
		assertEquals(speed, n.getSpeedText());
	}

	@Test
	public void testGetSpeedScore() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		// check if equals. We know from the setup that the speed score is 6
		assertEquals(6, n.getSpeedScore());
	}

	@Test
	public void testSetSpeedScore() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		// setup new speed score and change it on the note
		int speed = 2;
		n.setSpeedScore(speed);
		
		assertEquals(speed, n.getSpeedScore());
	}

	@Test
	public void testGetAttitudeText() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		// check if equals. We know from the setup that attitude test is "God"
		assertEquals("God", n.getAttitudeText());
	}

	@Test
	public void testSetAttitudeText() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		// setup a new attitude text and change it on the note
		String attitude = "Dårlig";
		n.setAttitudeText(attitude);
		
		assertEquals(attitude, n.getAttitudeText());
	}

	@Test
	public void testGetAttitudeScore() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		// check if equals. We know from the setup that the attitude score is 4
		assertEquals(4, n.getAttitudeScore());
	}

	@Test
	public void testSetAttitudeScore() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		// setup new attitude score and change it on the note
		int attitude = 5;
		n.setAttitudeScore(attitude);
		
		assertEquals(attitude, n.getAttitudeScore());
	}

	@Test
	public void testGetTechniqueText() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		// check if equal. We know from the setup that technique text should be "Middelmådig"		
		assertEquals("Middelmådig", n.getTechniqueText());
	}

	@Test
	public void testSetTechniqueText() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		// setup new technique text and change it on the note
		String technique = "Forrygende";
		n.setTechniqueText(technique);
		
		assertEquals(technique, n.getTechniqueText());
	}

	@Test
	public void testGetTechniqueScore() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		// check if equal. We know from the setup that technique score should be 3
		assertEquals(3, n.getTechniqueScore());
	}

	@Test
	public void testSetTechniqueScore() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		// setup new technique score and change it on the note
		int technique = 5;		
		n.setTechniqueScore(technique);
		
		assertEquals(technique, n.getTechniqueScore());
	}

	@Test
	public void testGetGameSenseText() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		// check if equal. We know from the setup that game sense text should be "Står godt på banen"
		assertEquals("Står godt på banen", n.getGameSenseText());
	}

	@Test
	public void testSetGameSenseText() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		// setup new game sense text and change it on the note
		String gameSense = "Står helt forkert på banen";
		n.setGameSenseText(gameSense);
		
		assertEquals(gameSense, n.getGameSenseText());
	}

	@Test
	public void testGetGameSenseScore() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		// check if equal. We know from the setup that game sense text should be 4
		assertEquals(4, n.getGameSenseScore());
	}

	@Test
	public void testSetGameSenseScore() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		// setup new game sense score and change it on the note
		int gameSense = 1;
		n.setGameSenseScore(gameSense);
		
		assertEquals(gameSense, n.getGameSenseScore());
	}
	
	@Test
	public void testUpdate() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		// setup note and add it to the player
		Note n = p.addNote(ss, speedText, speedScore, attitudeText,
				attitudeScore, techniqueText, techniqueScore, gameSenseText, gameSenseScore);
		
		UUID playerUUID = p.getID();
		UUID sessionUUID = ss.getSessionID();
		
		// check that the note n has both a player and a session
		assertNotNull(n.getPlayer());
		assertNotNull(n.getSession());
		
		// remove the player p from the database and check if the note n has lost both
		// the player and the session, thereby making it eligible for garbage collection
		UserInterface.PDB.removePlayer(p);
		assertNull(n.getPlayer());
		assertNull(n.getSession());
	}
}