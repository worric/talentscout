import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {
	
	static String name;
	static int age;
	static String club;
	
	static String location;
	static Date date;
	
	//static ScoutingSession s;
	//static Player 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		name = "Karl";
		age = 14;
		club ="Aab";
		
		date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		location = "Skodsborg";
		//s = UserInterface.AGENDA.planSession(location, date);
		//sessionID = s.getSessionID();
		
	}

	@Before
	public void setUp() throws Exception {
		
		// Pre-registering three player objects to simulate the presence
		// of a few objects in the database already
		UserInterface.PDB.register(name, age, club);
		UserInterface.PDB.register("Børge", 12, "Hørning");
		UserInterface.PDB.register("Johan", 54, "Skagen IK");
		
		// pre-planning one scoutingsession in the agenda db
		UserInterface.AGENDA.planSession(location, date);
	}

	@After
	public void tearDown() throws Exception {
		// 
		UserInterface.PDB.getArrayListPlayer().clear();
		for(int i = 0; i < UserInterface.AGENDA.getNumberOfSessions(); i++){
			ScoutingSession s = UserInterface.AGENDA.getSessionByIndex(i);
			UserInterface.AGENDA.cancelSession(s);
		}
	}

	@Test
	public void testPlayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddNoteScoutingSessionStringIntStringIntStringIntStringInt() {
		Player p = UserInterface.PDB.register(name, age, club);
		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		Note n = p.addNote(s, "God", 4, "Bakker godt op", 4, "Teknisk svag", 2, 
				"Står godt på banen", 6);
		
		// Compare index 0 note on the player, which is the only note on the given player
		assertEquals(n, p.getNote(0));
	}

	@Test
	public void testAddNoteNote() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNote() {
		Player p = UserInterface.PDB.register(name, age, club);
		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		Note n = p.addNote(s, "God", 4, "Bakker godt op", 4, "Teknisk svag", 2, 
				"Står godt på banen", 6);
		
		assertEquals(n, p.getNote(0));
	}

	@Test
	public void testGetNumberOfNotes() {
		Player p = UserInterface.PDB.register(name, age, club);
		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		Note n = p.addNote(s, "God", 4, "Bakker godt op", 4, "Teknisk svag", 2, 
				"Står godt på banen", 6);
		Note n2 = p.addNote(s, "Middel", 3, "Har temperament", 2, "Teknisk stærk", 5, 
				"Står lidt galt på banen", 3);
		
	}

	@Test
	public void testDisplayNote() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisplayNoteOverview() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAverage() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisplayAverageScore() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAge() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAge() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClub() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetClub() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetID() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetInactive() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetActive() {
		fail("Not yet implemented");
	}

}
